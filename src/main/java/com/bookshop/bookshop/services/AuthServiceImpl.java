package com.bookshop.bookshop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.bookshop.Entity.UserEntity;
import com.bookshop.bookshop.dto.LoginRequest;
import com.bookshop.bookshop.dto.SignupRequest;
import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO signup(SignupRequest request) {
        Optional<UserEntity> existing = userRepository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("User already exists");
        }

        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Plain text (not secure, for learning/demo)
        user.setRole(request.getRole().toUpperCase());

        UserEntity saved = userRepository.save(user);
        return new UserDTO(saved.getUserId(), saved.getEmail(), saved.getRole());
    }

    @Override
    public UserDTO login(LoginRequest request) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return new UserDTO(user.getUserId(), user.getEmail(), user.getRole());
            }
            throw new RuntimeException("Incorrect password");
        }
        throw new RuntimeException("User not found");
    }

}


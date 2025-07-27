package com.bookshop.bookshop.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.bookshop.Entity.UserEntity;
import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();

        return users.stream().map(user -> {
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        Optional<UserEntity> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            UserDTO dto = new UserDTO();
            dto.setUserId(user.getUserId());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());
            return dto;
        } else {
            return null; // or throw an exception if preferred
        }
    }

    @Override
public boolean deleteUserById(Long userId) {
    if (userRepository.existsById(userId)) {
        userRepository.deleteById(userId);
        return true;
    }
    return false;
}
}

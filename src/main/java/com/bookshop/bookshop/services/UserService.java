package com.bookshop.bookshop.services;

import java.util.List;

import com.bookshop.bookshop.dto.UserDTO;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long userId);
    boolean deleteUserById(Long userId);
}

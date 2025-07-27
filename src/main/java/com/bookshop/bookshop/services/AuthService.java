package com.bookshop.bookshop.services;

import com.bookshop.bookshop.dto.LoginRequest;
import com.bookshop.bookshop.dto.SignupRequest;
import com.bookshop.bookshop.dto.UserDTO;

public interface AuthService {
    UserDTO signup(SignupRequest request);
    UserDTO login(LoginRequest request);
}

package com.bookshop.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.bookshop.dto.LoginRequest;
import com.bookshop.bookshop.dto.SignupRequest;
import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.services.AuthService;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public UserDTO signup(@RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public UserDTO login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}


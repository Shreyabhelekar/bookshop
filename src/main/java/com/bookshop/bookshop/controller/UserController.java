package com.bookshop.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.bookshop.dto.UserDTO;
import com.bookshop.bookshop.services.UserService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/admin/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/{userId}")
public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
    boolean deleted = userService.deleteUserById(userId);

    if (deleted) {
        return ResponseEntity.ok().build();
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User could not be deleted");
    }
}
}

package com.bookshop.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.bookshop.dto.CartDTO;
import com.bookshop.bookshop.services.CartService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/user/cart")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addToCart(cartDTO);
    }

    @GetMapping("/item/{userId}")
    public List<CartDTO> getCartItems(@PathVariable Long userId) {
        return cartService.getCartItemsByUser(userId);
    }

    @DeleteMapping("/{cartId}")
    public String removeFromCart(@PathVariable Long cartId) {
        return cartService.removeFromCart(cartId);
    }
}

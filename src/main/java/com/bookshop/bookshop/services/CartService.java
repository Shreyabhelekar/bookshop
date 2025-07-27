package com.bookshop.bookshop.services;

import java.util.List;

import com.bookshop.bookshop.dto.CartDTO;

public interface CartService {
    String addToCart(CartDTO cartDTO);
    List<CartDTO> getCartItemsByUser(Long userId);   // Uses actual User entity for secure filtering
    String removeFromCart(Long cartId);
}
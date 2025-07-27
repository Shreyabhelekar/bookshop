package com.bookshop.bookshop.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.bookshop.Entity.BookEntity;
import com.bookshop.bookshop.Entity.CartEntity;
import com.bookshop.bookshop.Entity.UserEntity;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.dto.CartDTO;
import com.bookshop.bookshop.repository.BookRepository;
import com.bookshop.bookshop.repository.CartRepository;
import com.bookshop.bookshop.repository.UserRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addToCart(CartDTO dto) {
        BookEntity book = bookRepository.findById(dto.getBook().getBookId()).orElse(null);
        UserEntity user = userRepository.findById(dto.getUserId()).orElse(null);

        if (book == null) return "Book not found";
        if (user == null) return "User not found";

        Optional<CartEntity> existingCart = cartRepository.findByUserAndBook(user, book);

        if (existingCart.isPresent()) {
            CartEntity cartItem = existingCart.get();
            cartItem.setQuantity(cartItem.getQuantity() + dto.getQuantity());
            cartRepository.save(cartItem);
            return "Cart updated with new quantity";
        }

        CartEntity newCart = new CartEntity();
        newCart.setUser(user);
        newCart.setBook(book);
        newCart.setQuantity(dto.getQuantity());
        cartRepository.save(newCart);

        return "Book added to cart";
    }

    @Override
    public List<CartDTO> getCartItemsByUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) return Collections.emptyList();

        return cartRepository.findByUser(user).stream()
                .filter(cart -> cart.getBook() != null)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public String removeFromCart(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
            return "Item removed from cart";
        }
        return "Cart item not found";
    }

    private CartDTO mapToDTO(CartEntity cart) {
        BookEntity book = cart.getBook();
        BookDTO bookDTO = new BookDTO(
            book.getBookId(),
            book.getBookName(),
            book.getAuthor(),
            book.getPrice(),
            book.getStock()
        );

        CartDTO dto = new CartDTO();
        dto.setCartId(cart.getCartId());
        dto.setUserId(cart.getUser().getUserId());
        dto.setBook(bookDTO);
        dto.setQuantity(cart.getQuantity());
        dto.setAddedAt(cart.getAddedAt());

        return dto;
    }
}
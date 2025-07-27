package com.bookshop.bookshop.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.bookshop.Entity.BookEntity;
import com.bookshop.bookshop.Entity.OrderEntity;
import com.bookshop.bookshop.Entity.UserEntity;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.dto.OrderDTO;
import com.bookshop.bookshop.repository.BookRepository;
import com.bookshop.bookshop.repository.OrderRepository;
import com.bookshop.bookshop.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String placeOrder(Long userId, Long bookId, int quantity) {
        BookEntity book = bookRepository.findById(bookId).orElse(null);
        UserEntity user = userRepository.findById(userId).orElse(null);

        if (book == null) return "Book not found!";
        if (user == null) return "User not found!";
        if (book.getStock() < quantity) return "Not enough stock available!";

        book.setStock(book.getStock() - quantity);
        bookRepository.save(book);

        double totalPrice = book.getPrice() * quantity;

        OrderEntity order = OrderEntity.builder()
            .user(user)
            .book(book)
            .quantity(quantity)
            .price(totalPrice)
            .build();

        orderRepository.save(order);
        return "Order placed successfully!";
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) return Collections.emptyList();

        return orderRepository.findByUser(user).stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    private OrderDTO mapToDTO(OrderEntity order) {
        BookEntity book = order.getBook();
        BookDTO bookDTO = new BookDTO(
            book.getBookId(),
            book.getBookName(),
            book.getAuthor(),
            book.getPrice(),
            book.getStock()
        );

        return OrderDTO.builder()
            .orderId(order.getOrderId())
            .userId(order.getUser().getUserId())
            .book(bookDTO)
            .quantity(order.getQuantity())
            .price(order.getPrice())             // 🔥 Included: price
            .orderDate(order.getOrderDate())     // 🔥 Included: order date
            .build();
    }
}
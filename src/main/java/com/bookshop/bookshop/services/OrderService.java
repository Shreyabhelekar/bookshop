package com.bookshop.bookshop.services;

import java.util.List;

import com.bookshop.bookshop.dto.OrderDTO;

public interface OrderService {
    String placeOrder(Long userId, Long bookId, int quantity);
    List<OrderDTO> getOrdersByUser(Long userId);
    List<OrderDTO> getAllOrders();
}

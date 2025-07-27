package com.bookshop.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.bookshop.dto.OrderDTO;
import com.bookshop.bookshop.services.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public String placeOrder(
            @RequestParam Long userId,
            @RequestParam Long bookId,
            @RequestParam int quantity) {
        return orderService.placeOrder(userId, bookId, quantity);
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @GetMapping("/admin/all")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
}
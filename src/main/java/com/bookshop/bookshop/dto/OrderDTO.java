package com.bookshop.bookshop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long orderId;
    private Long userId;
    private BookDTO book;
    private int quantity;
    private double price;
    private LocalDateTime orderDate;
}

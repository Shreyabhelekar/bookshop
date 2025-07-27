package com.bookshop.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long bookId;
    private String bookName;
    private String author;
    private double price;
    private int stock;
    
}

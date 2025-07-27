package com.bookshop.bookshop.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_db")
public class BookEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bookId;
    private String bookName;
    private String author;
    private double price;
    private int stock;
}

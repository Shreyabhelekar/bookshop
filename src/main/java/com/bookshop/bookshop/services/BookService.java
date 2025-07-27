package com.bookshop.bookshop.services;

import java.util.List;

import com.bookshop.bookshop.dto.BookDTO;

public interface  BookService {
    String addBook(BookDTO bookDTO);
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long bookId);
    String updateBook(Long bookId, BookDTO bookDTO);
    String deleteBook(Long bookId);
}

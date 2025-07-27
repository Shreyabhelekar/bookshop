package com.bookshop.bookshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.bookshop.Entity.BookEntity;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String addBook(BookDTO dto) {
        BookEntity book = new BookEntity();
        book.setBookName(dto.getBookName());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());
        book.setStock(dto.getStock());
        bookRepository.save(book);
        return "Book added successfully";
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(b -> new BookDTO(
                b.getBookId(), b.getBookName(), b.getAuthor(), b.getPrice(), b.getStock()
        )).collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(b -> new BookDTO(b.getBookId(), b.getBookName(), b.getAuthor(), b.getPrice(), b.getStock()))
                .orElse(null);
    }

    @Override
    public String deleteBook(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return "Book deleted successfully";
        }
        return "Book not found, cannot delete";
    }
    
    @Override
    public String updateBook(Long bookId, BookDTO dto) {
        return bookRepository.findById(bookId).map(b -> {
            b.setBookName(dto.getBookName());
            b.setAuthor(dto.getAuthor());
            b.setPrice(dto.getPrice());
            b.setStock(dto.getStock());
            bookRepository.save(b);
            return "Book updated successfully";
        }).orElse("Book not found");
    }

}

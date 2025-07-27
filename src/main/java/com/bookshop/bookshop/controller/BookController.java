package com.bookshop.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.services.BookService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/books")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

   @DeleteMapping("/{bookId}")
public ResponseEntity<String> deleteBook(@PathVariable Long bookId) {
    String result = bookService.deleteBook(bookId);
    if (result.equals("Book deleted successfully")) {
        return ResponseEntity.ok(result);
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}

@PutMapping("/{bookId}")
public ResponseEntity<String> updateBook(@PathVariable Long bookId, @RequestBody BookDTO bookDTO) {
    String result = bookService.updateBook(bookId, bookDTO);
    if (result.equals("Book updated successfully")) {
        return ResponseEntity.ok(result);
    } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
}

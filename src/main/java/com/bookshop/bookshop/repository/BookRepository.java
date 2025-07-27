package com.bookshop.bookshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.bookshop.Entity.BookEntity;
public interface BookRepository extends JpaRepository<BookEntity, Long>{
    
}

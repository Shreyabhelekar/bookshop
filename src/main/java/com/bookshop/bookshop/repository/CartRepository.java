package com.bookshop.bookshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.bookshop.Entity.BookEntity;
import com.bookshop.bookshop.Entity.CartEntity;
import com.bookshop.bookshop.Entity.UserEntity;


public interface  CartRepository extends JpaRepository<CartEntity, Long>{
    List<CartEntity> findByUser(UserEntity user);
    Optional<CartEntity> findByUserAndBook(UserEntity user, BookEntity book);

}

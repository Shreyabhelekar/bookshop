package com.bookshop.bookshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.bookshop.Entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}

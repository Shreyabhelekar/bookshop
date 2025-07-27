package com.bookshop.bookshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookshop.bookshop.Entity.OrderEntity;
import com.bookshop.bookshop.Entity.UserEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByUser(UserEntity user);
}

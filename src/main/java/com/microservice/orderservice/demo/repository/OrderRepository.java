package com.microservice.orderservice.demo.repository;

import com.microservice.orderservice.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}

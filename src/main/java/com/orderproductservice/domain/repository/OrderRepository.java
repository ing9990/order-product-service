package com.orderproductservice.domain.repository;

import com.orderproductservice.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.Optional;

@Repository
public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}

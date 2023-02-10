package com.orderproductservice.domain.repository;

import com.orderproductservice.domain.Order;

import java.util.UUID;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(UUID id);

    void save(Order order);
}

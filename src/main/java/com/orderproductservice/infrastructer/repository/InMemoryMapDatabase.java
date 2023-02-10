package com.orderproductservice.infrastructer.repository;

import com.orderproductservice.domain.Order;
import com.orderproductservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryMapDatabase implements OrderRepository {

    public static Map<UUID, Order> orderRepository = new HashMap<>();

    @Override
    public Optional<Order> findById(UUID id) {
        return Optional.of(orderRepository.get(id));
    }

    @Override
    public void save(Order order) {
        orderRepository.put(order.getId(), order);
    }
}
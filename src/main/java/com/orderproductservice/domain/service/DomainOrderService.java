package com.orderproductservice.domain.service;

import com.orderproductservice.domain.Order;
import com.orderproductservice.domain.Product;
import com.orderproductservice.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public UUID createOrder(Product product) {
        final Order order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public void addProduct(UUID id, Product product) {
        final Order order = getOrder(id);
        order.addOrder(product);

        orderRepository.save(order);
    }

    @Override
    public void completeOrder(UUID id) {
        final Order order = getOrder(id);
        order.complete();

        orderRepository.save(order);
    }

    @Override
    public void deleteProduct(UUID id, UUID productId) {
        final Order order = getOrder(id);
        order.removeOrder(productId);

        orderRepository.save(order);
    }

    private Order getOrder(UUID id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Order with given id doesn't exist"));
    }
}

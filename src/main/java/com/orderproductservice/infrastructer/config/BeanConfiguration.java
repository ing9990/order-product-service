package com.orderproductservice.infrastructer.config;

import com.orderproductservice.OrderProductServiceApplication;
import com.orderproductservice.domain.repository.OrderRepository;
import com.orderproductservice.domain.service.DomainOrderService;
import com.orderproductservice.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = OrderProductServiceApplication.class)
public class BeanConfiguration {

    @Bean
    OrderService orderService(final OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}

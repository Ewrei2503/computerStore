package com.example.computerStock.repos;

import com.example.computerStock.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Transactional
    void removeById(Long id);

    List<Order> findOrdersByType(Boolean type);

    Order findOrderById(Long id);
}

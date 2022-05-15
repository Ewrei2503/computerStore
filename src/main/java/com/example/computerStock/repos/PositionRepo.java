package com.example.computerStock.repos;

import com.example.computerStock.domain.Order;
import com.example.computerStock.domain.Position;
import com.example.computerStock.domain.pcComponents.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepo extends JpaRepository<Position, Long> {
    /*@Query(value = "SELECT p.product, COUNT(p.product) FROM Position AS p WHERE p.order = :id GROUP BY p.product")
    Position countCustomersByType(Long id);*/

    List<Position> findByOrderId(Long id);
}

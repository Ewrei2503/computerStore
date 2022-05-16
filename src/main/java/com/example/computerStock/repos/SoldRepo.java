package com.example.computerStock.repos;

import com.example.computerStock.domain.Sold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoldRepo extends JpaRepository<Sold, Long> {
    List<Sold> findSoldByProductId(Long id);
}

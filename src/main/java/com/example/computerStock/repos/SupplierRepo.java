package com.example.computerStock.repos;

import com.example.computerStock.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    Supplier findByName(String name);
}

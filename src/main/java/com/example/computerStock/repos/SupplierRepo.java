package com.example.computerStock.repos;

import com.example.computerStock.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SupplierRepo extends JpaRepository<Supplier, Long> {
    Supplier findByName(String name);

    @Transactional
    void deleteSupplierById(Long id);

    Supplier findSupplierById(Long id);
}

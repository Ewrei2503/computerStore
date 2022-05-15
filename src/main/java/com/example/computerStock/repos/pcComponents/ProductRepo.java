package com.example.computerStock.repos.pcComponents;

import com.example.computerStock.domain.pcComponents.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findProductByModelAndCompany(String model, String company);

    Product findProductById(Long id);

    @Transactional
    void removeById(Long id);
}

package com.example.computerStock.repos.pcComponents;

import com.example.computerStock.domain.pcComponents.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findProductByModel(String model);
    Product findByOrderByCompanyAsc();
    Product findProductByModelAndCompany(String model, String company);
}

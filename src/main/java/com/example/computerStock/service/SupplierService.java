package com.example.computerStock.service;

import com.example.computerStock.domain.Supplier;
import com.example.computerStock.repos.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepo supplierRepo;

    public List<Supplier> findAll() {
        return supplierRepo.findAll();
    }
}

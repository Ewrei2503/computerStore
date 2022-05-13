package com.example.computerStock.service;

import com.example.computerStock.domain.Supplier;
import com.example.computerStock.repos.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    SupplierRepo supplierRepo;

    public boolean addSupplier(Supplier supplier){
        Supplier supplierFromDb = supplierRepo.findByName(supplier.getName());

        if(supplierFromDb != null) return false;
        //supplier;
        return true;
    }
}

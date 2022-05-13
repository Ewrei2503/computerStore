package com.example.computerStock.service;

import com.example.computerStock.domain.pcComponents.*;
import com.example.computerStock.repos.pcComponents.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private VideocardRepo videocardRepo;
    @Autowired
    private ProcessorRepo processorRepo;
    @Autowired
    private MotherboardRepo motherboardRepo;
    @Autowired
    private RamRepo ramRepo;
    @Autowired
    private DriveRepo driveRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public boolean checkProduct(Product product){
        Product productFromDb = productRepo.findProductByModelAndCompany(product.getModel(), product.getCompany());

        if(productFromDb != null) return false;
        return true;
    }

    public void addProduct(Videocard videocard) {
        videocardRepo.save(videocard);
    }
    public void addProduct(Processor proc) {
        processorRepo.save(proc);
    }
    public void addProduct(Drive drive) {
        driveRepo.save(drive);
    }
    public void addProduct(Ram ram) {
        ramRepo.save(ram);
    }
    public void addProduct(Motherboard motherboard) {
        motherboardRepo.save(motherboard);
    }
}

package com.example.computerStock.controller;

import com.example.computerStock.domain.Supplier;
import com.example.computerStock.repos.MessageRepo;
import com.example.computerStock.repos.OrderRepo;
import com.example.computerStock.repos.SupplierRepo;
import com.example.computerStock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("")
    public String supplierList(
            Model model
    ){
        model.addAttribute("suppliers", supplierRepo.findAll());
        return "supplier";
    }
    @GetMapping("add")
    public String createSupplier(
    ){
        return "supplierAdd";
    }

    @PostMapping("add")
    public String addSupplier(
            @RequestParam String email,
            @RequestParam String name
    ){
        Supplier sup = new Supplier(email,name);
        supplierRepo.save(sup);
        return "redirect:/supplier";
    }

    @GetMapping("{supplier}")
    public String editSupplier(
            @PathVariable Supplier supplier,
            Model model
    ){
        model.addAttribute("supplier", supplier);
        return "supplierEdit";
    }

    @PostMapping("{supplier}")
    public String editSupplier(
            @PathVariable Supplier supplier,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String name
    ){
        supplier.setEmail(email);
        supplier.setName(name);
        supplierRepo.save(supplier);
        return "redirect:/supplier";
    }

    @PostMapping("{supplier}/delete")
    public String deleteSupplier(
            @PathVariable Supplier supplier
    ){
        supplierRepo.deleteSupplierById(supplier.getId());
        return "redirect:/supplier";
    }

}

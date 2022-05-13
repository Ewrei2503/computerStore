package com.example.computerStock.controller;

import com.example.computerStock.domain.pcComponents.*;
import com.example.computerStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String productList(
            Model model
    ) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @GetMapping("createProduct")
    public String createProduct(
            Model model
    ) {
        return "createProduct";
    }

    @PostMapping("createProduct")
    public String addProduct(
            @RequestParam String company,
            @RequestParam String model,
            @RequestParam String type,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer clock,
            @RequestParam(required = false) Integer cores,
            @RequestParam(required = false) Integer thread,
            @RequestParam(required = false) String socket,
            @RequestParam(required = false) Boolean typeDrive
    ){
        Product prod = new Product(company,model,type);
        if(!productService.checkProduct(prod)) return "createProduct";
        switch(prod.getType()){
            case "videocard":
                Videocard vid = new Videocard(company,model,type,memory,clock);
                productService.addProduct(vid);
                return "redirect:/product";
            case "processor":
                Processor proc = new Processor(company,model,type,cores,thread,clock);
                productService.addProduct(proc);
                return "redirect:/product";
            case "ram":
                Ram ram = new Ram(company,model,type,memory,clock);
                productService.addProduct(ram);
                return "redirect:/product";
            case "drive":
                Drive drive = new Drive(company,model,type,memory,clock,typeDrive);
                productService.addProduct(drive);
                return "redirect:/product";
            case "motherboard":
                Motherboard motherboard = new Motherboard(company,model,type,socket);
                productService.addProduct(motherboard);
                return "redirect:/product";
        }
        return "redirect:/product";
    }
}

package com.example.computerStock.controller;

import com.example.computerStock.domain.pcComponents.*;
import com.example.computerStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam Double price,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer clock,
            @RequestParam(required = false) Integer cores,
            @RequestParam(required = false) Integer thread,
            @RequestParam(required = false) String socket,
            @RequestParam(required = false) Boolean typeDrive
    ){
        Product prod = new Product(company,model,type,price);
        if(!productService.checkProduct(prod)) return "createProduct";
        switch(prod.getType()){
            case "videocard":
                Videocard vid = new Videocard(company,model,type,memory,clock, price);
                productService.addProduct(vid);
                return "redirect:/product";
            case "processor":
                Processor proc = new Processor(company,model,type,cores,thread,clock, price);
                productService.addProduct(proc);
                return "redirect:/product";
            case "ram":
                Ram ram = new Ram(company,model,type,memory,clock, price);
                productService.addProduct(ram);
                return "redirect:/product";
            case "drive":
                Drive drive = new Drive(company,model,type,memory,typeDrive, price);
                productService.addProduct(drive);
                return "redirect:/product";
            case "motherboard":
                Motherboard motherboard = new Motherboard(company,model,type,socket,price);
                productService.addProduct(motherboard);
                return "redirect:/product";
        }
        return "redirect:/product";
    }

    @PostMapping("/{id}/delete")
    public String deleteProduct(
            @PathVariable(value = "id") Long id,
            Model model
    ){
        productService.deleteProduct(id);
        model.addAttribute("product", productService.findAll());
        return "redirect:/product";
    }

    @GetMapping("/{product}/edit")
    public String editProduct(
            @PathVariable(value = "product") Product product,
            Model model
    ){
        model.addAttribute("product", product);
        return "productEdit";
    }

    @PostMapping("/{product}/edit")
    public String saveProduct(
            @PathVariable(value = "product") Product product,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer clock,
            @RequestParam(required = false) Integer cores,
            @RequestParam(required = false) Integer thread,
            @RequestParam(required = false) String socket,
            @RequestParam(required = false) Boolean typeDrive
    ){
        product.setCompany(company);
        product.setPrice(price);
        product.setModel(model);
        switch(product.getType()){
            case "videocard":
                Videocard vid = new Videocard(product,memory,clock);
                productService.addProduct(vid);
                return "redirect:/product";
            case "processor":
                Processor proc = new Processor(product,cores,thread,clock);
                productService.addProduct(proc);
                return "redirect:/product";
            case "ram":
                Ram ram = new Ram(product,memory,clock);
                productService.addProduct(ram);
                return "redirect:/product";
            case "drive":
                Drive drive = new Drive(product,memory,typeDrive);
                productService.addProduct(drive);
                return "redirect:/product";
            case "motherboard":
                Motherboard motherboard = new Motherboard(product,socket);
                productService.addProduct(motherboard);
                return "redirect:/product";
        }
        return "redirect:/product";
    }
}


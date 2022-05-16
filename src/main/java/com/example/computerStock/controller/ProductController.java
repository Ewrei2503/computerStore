package com.example.computerStock.controller;

import com.example.computerStock.domain.pcComponents.*;
import com.example.computerStock.repos.pcComponents.*;
import com.example.computerStock.service.OrderService;
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
    @Autowired
    private OrderService orderService;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String productList(
            Model model
    ) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("createProduct")
    public String createProduct(
            Model model
    ) {
        return "createProduct";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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
                Drive drive = new Drive(company,model,type,memory,typeDrive);
                productService.addProduct(drive);
                return "redirect:/product";
            case "motherboard":
                Motherboard motherboard = new Motherboard(company,model,type,socket);
                productService.addProduct(motherboard);
                return "redirect:/product";
        }
        return "redirect:/product";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}/delete")
    public String deleteProduct(
            @PathVariable(value = "id") Long id,
            Model model
    ){

        orderService.deletePositions(id);
        productService.deleteProduct(id);
        model.addAttribute("product", productService.findAll());
        return "redirect:/product";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{product}/edit")
    public String editProduct(
            @PathVariable(value = "product") Product product,
            Model model
    ){
        model.addAttribute("product", product);
        return "productEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{product}/edit")
    public String saveProduct(
            @PathVariable(value = "product") Product product,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer clock,
            @RequestParam(required = false) Integer cores,
            @RequestParam(required = false) Integer thread,
            @RequestParam(required = false) String socket,
            @RequestParam(required = false) Boolean typeDrive
    ){
        product.setCompany(company);
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
    @GetMapping("/{product}/detail")
    public String showDetails(
            @PathVariable Product product,
            Model model
    ){
        switch(product.getType()){
            case "videocard":
                model.addAttribute("product", videocardRepo.findVideocardById(product.getId()));
                return "productDetails";
            case "processor":
                model.addAttribute("product", processorRepo.findProcessorById(product.getId()));
                return "productDetails";
            case "ram":
                model.addAttribute("product", ramRepo.findRamById(product.getId()));
                return "productDetails";
            case "drive":
                model.addAttribute("product", driveRepo.findDriveById(product.getId()));
                return "productDetails";
            case "motherboard":
                model.addAttribute("product", motherboardRepo.findMotherboardById(product.getId()));
                return "productDetails";
        }
        return "productDetails";
    }
}


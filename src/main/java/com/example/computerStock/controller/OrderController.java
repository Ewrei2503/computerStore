package com.example.computerStock.controller;

import com.example.computerStock.domain.Order;
import com.example.computerStock.repos.OrderRepo;
import com.example.computerStock.repos.PositionRepo;
import com.example.computerStock.service.OrderService;
import com.example.computerStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String orderList(
            Model model
    ){
        model.addAttribute("orders", orderService.findAll());
        return "order";
    }

    @GetMapping("createOrder")
    public String createOrder(
            Model model
    ){
        return "createOrder";
    }

    @PostMapping("create")
    public String addOrderForExecutor(
            @RequestParam Boolean type
    ){
        orderService.addOrder(type);
        return "redirect:/order";
    }

    @GetMapping("{order}")
    public String orderToUsers(
            @PathVariable Order order,
            Model model
    ){
        model.addAttribute("products",productService.findAll());
        model.addAttribute("positions",orderService.findOrderData(order));
        model.addAttribute("order", order);
        return "orderToUsers";
    }

    @PostMapping("{order}/add")
    public String addPosition(
            @RequestParam Integer num,
            @PathVariable Order order,
            @RequestParam Long id
    ){
        orderService.addPosition(num, order, id);
        return "redirect:/order";
    }
}

package com.example.computerStock.controller;

import com.example.computerStock.domain.Order;
import com.example.computerStock.domain.Position;
import com.example.computerStock.domain.Supplier;
import com.example.computerStock.repos.PositionRepo;
import com.example.computerStock.repos.SupplierRepo;
import com.example.computerStock.repos.pcComponents.ProductRepo;
import com.example.computerStock.service.MailSenderService;
import com.example.computerStock.service.OrderService;
import com.example.computerStock.service.ProductService;
import com.example.computerStock.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MailSenderService mailSender;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PositionRepo positionRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private SupplierService supplierService;

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
        orderService.addPosition(num, order, id, false);
        return "redirect:/order/{order}";
    }

    @PostMapping("{order}/add2")
    public String addPosition2(
            @RequestParam Integer num,
            @PathVariable Order order,
            @RequestParam Long id
    ){
        orderService.addPosition(num, order, id, true);
        return "redirect:/order/{order}";
    }

    @PostMapping("{order}/{position}/delete")
    public String deletePosition(
            @PathVariable Order order,
            @PathVariable Position position
    ){
        orderService.deletePosition(position);
        return "redirect:/order/{order}";
    }

    @PostMapping("{order}/{position}/delete2")
    public String deletePosition2(
            @PathVariable Order order,
            @PathVariable Position position
    ){
        orderService.deletePosition(position);
        return "redirect:/order/{order}/toSup";
    }

    @PostMapping("{order}/delete")
    public String deleteOrder(
            @PathVariable Order order
    ){
        orderService.deleteOrder(order);
        return "redirect:/order";
    }

    @PostMapping("/toSupplier")
    public String orderToSupplier(
            @RequestParam Boolean type
    ){
        orderService.addOrder(type);
        return "redirect:/order";
    }

    @GetMapping("{order}/toSup")
    public String orderToSup(
            @PathVariable Order order,
            Model model
    ){
        model.addAttribute("suppliers", supplierService.findAll());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("positions",orderService.findOrderData(order));
        model.addAttribute("order", order);
        return "orderFromSupplier";
    }

    @PostMapping("/{order}/sendToSupplier")
    public String sendToSupplier(
            @PathVariable Order order,
            @RequestParam Long supplier
    ){
        Supplier sup = supplierRepo.findSupplierById(supplier);
        String message = String.format(
                "Здравствуйте, %s \n" +
                        "Мы, от лица нашей организации просим вас поставить нам товар \n" +
                        " для просмотра перейдитие по ссылке: http://localhost:8080/order/activation/%s/",
                sup.getId(),
                order.getId()
        );
        mailSender.send(sup.getEmail(), "Поставка товара",message);
        return "redirect:/order";
    }

    @GetMapping("activation/{order}/")
    public String recieveAnswer(
            Order order,
            Model model
    ){

        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("positions", positionRepo.findByOrderId(order.getId()));
        model.addAttribute("order", order);
        return "activation";
    }
    @PostMapping("activation/{order}")
    public String recieveAnswer(
            @PathVariable Order order,
            @RequestParam Boolean answer
    ){
        if(!answer){
            orderService.deleteOrder(order);
            return "redirect:/";
        }
        orderService.resolveNumbers(order);
        return "redirect:/order";
    }
}

package com.example.computerStock.controller;

import com.example.computerStock.domain.Message;
import com.example.computerStock.domain.Order;
import com.example.computerStock.domain.User;
import com.example.computerStock.repos.MessageRepo;
import com.example.computerStock.repos.OrderRepo;
import com.example.computerStock.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quest")
public class QuestController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping
    public String questList(
            @AuthenticationPrincipal User user,
            Model model
    ){

        model.addAttribute("orders", orderRepo.findOrdersByType(false));
        return "questList";
    }
    @GetMapping("/add/{order}")
    public String addQuest(
            @AuthenticationPrincipal User user,
            @PathVariable Order order,
            Model model
    ){

        model.addAttribute("order", order);
        model.addAttribute("users", userRepo.findAll());
        model.addAttribute("orders", orderRepo.findOrdersByType(false));
        return "addQuest";
    }
    @PostMapping("/add/{order}")
    public String addQuest(
            @RequestParam String tag,
            @RequestParam String text,
            @RequestParam String messageFor,
            @AuthenticationPrincipal User user,
            @RequestParam Long id
    ){
        Order order = orderRepo.findOrderById(id);
        Message msg = new Message(text,tag,user,order,messageFor);
        order.setExecutor(userRepo.findByUsername(messageFor));
        messageRepo.save(msg);
        orderRepo.save(order);
        return "redirect:/quest";
    }

}

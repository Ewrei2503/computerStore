package com.example.computerStock.controller;

import com.example.computerStock.domain.Message;
import com.example.computerStock.domain.User;
import com.example.computerStock.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting( Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            @RequestParam(required = false)String filter, Model model
    ){
        Iterable<Message> messages = messageRepo.findByMessageFor(user.getUsername());
        if(filter != null && !filter.isEmpty()){
            messages =  messageRepo.findByTagAndMessageFor(filter, user.getUsername());
        } else messages = messageRepo.findByMessageFor(user.getUsername());
        model.addAttribute("messages",messages);
        model.addAttribute("filter",filter);
        return "main";
    }
    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam String messageFor,
            Map<String, Object> model
    ){
        Message message = new Message(text,tag, user, messageFor);
        messageRepo.save(message);
        Iterable<Message> messages = messageRepo.findByMessageFor( user.getUsername());
        model.put("messages",messages);
        return "main";
    }

}

package com.example.computerStock.controller;

import com.example.computerStock.domain.Message;
import com.example.computerStock.domain.User;
import com.example.computerStock.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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
            @Valid Message message,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorMap);
            model.addAttribute("message",message);
        } else {
            message.setAuthor(user);
            messageRepo.save(message);
        }
        model.addAttribute("message", null);
        Iterable<Message> messages = messageRepo.findByMessageFor( user.getUsername());
        model.addAttribute("messages",messages);
        return "main";
    }




}

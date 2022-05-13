package com.example.computerStock.controller;

import com.example.computerStock.domain.User;
import com.example.computerStock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            @RequestParam("password2") String passwordConfirm,
            @Valid User user,
            BindingResult bindingResult,
            Model model
    ){
        boolean isConfirmEmpty = StringUtils.isEmpty(passwordConfirm);
        if(isConfirmEmpty){
            model.addAttribute("password2Error", "Введите повторный пароль");
        }
        if(isConfirmEmpty || bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "/registration";
        }

        if(user.getPassword() !=null && !user.getPassword().equals(passwordConfirm)){
            model.addAttribute("passwordError", "Пароли не равны!");
            return "/registration";
        }

        if(!userService.addUser(user)){
            model.addAttribute("usernameError", "User exists!");
            if(user.getPassword() !=null && !user.getPassword().equals(passwordConfirm)){
                model.addAttribute("passwordError", "Пароли не равны!");
                return "/registration";
            }
            return "/registration";
        }

        return "redirect:/user";
    }
}

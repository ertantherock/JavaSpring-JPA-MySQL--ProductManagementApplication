package com.example.productmanagementandpromotionwebapp.controllers;

import com.example.productmanagementandpromotionwebapp.entities.User;
import com.example.productmanagementandpromotionwebapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    final UserService userService;

    @GetMapping("/registerPage")
    public String registerPage(){

        return "register";
    }

    @PostMapping("/registerForm")
    public String registerForm(User user){
        userService.userSave(user);
        return "login";

    }

}

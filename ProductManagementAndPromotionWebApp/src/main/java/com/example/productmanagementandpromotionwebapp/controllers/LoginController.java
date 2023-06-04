package com.example.productmanagementandpromotionwebapp.controllers;

import com.example.productmanagementandpromotionwebapp.entities.User;
import com.example.productmanagementandpromotionwebapp.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;
    final HttpServletRequest request;
    final HttpServletResponse response;


    @GetMapping("/loginPage")
    public String loginPage(){

        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(User user){
        User u = loginService.userLogin(user);
        if (u != null) {
            request.getSession().setAttribute("user",u);


            return "redirect:/";
        }
        return "redirect:/loginPage";
    }

    @GetMapping("/logout")
    public String logout() {
        request.getSession().removeAttribute("user");
        return "redirect:/loginPage";
    }


}

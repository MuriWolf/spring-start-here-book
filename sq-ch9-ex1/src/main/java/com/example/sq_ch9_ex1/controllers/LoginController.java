package com.example.sq_ch9_ex1.controllers;

import com.example.sq_ch9_ex1.components.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String attemptLogin(Model page, @RequestParam String username, @RequestParam String password) {

        LoginProcessor loginProcessor = new LoginProcessor(username, password);
        boolean isLogged = loginProcessor.login();

        if (isLogged) {
            page.addAttribute("message", "successfully logged!");
        } else {
            page.addAttribute("message", "Login not worked. Try again.");
        }

        return "login.html";
    }
}

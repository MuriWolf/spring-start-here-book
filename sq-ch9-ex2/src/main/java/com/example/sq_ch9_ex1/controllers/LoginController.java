package com.example.sq_ch9_ex1.controllers;

import com.example.sq_ch9_ex1.components.LoggedUserManagementService;
import com.example.sq_ch9_ex1.components.LoginProcessor;
import com.example.sq_ch9_ex1.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;
    private final LoginCountService loginCountService;

    public LoginController(LoginProcessor loginProcessor, LoginCountService loginCountService) {
        this.loginProcessor = loginProcessor;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String attemptLogin(Model page, @RequestParam String username, @RequestParam String password) {

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean isLogged = loginProcessor.login();
        loginCountService.increment();

        if (isLogged) {
            return "redirect:/main";
        }

        page.addAttribute("message", "Login not worked. Try again.");
        return "login.html";
    }
}

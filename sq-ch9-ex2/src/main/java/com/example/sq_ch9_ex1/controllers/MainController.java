package com.example.sq_ch9_ex1.controllers;

import com.example.sq_ch9_ex1.components.LoggedUserManagementService;
import com.example.sq_ch9_ex1.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(Model page, @RequestParam(required = false) String logout) {
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        if (loggedUserManagementService.getUsername() != null) {
           page.addAttribute("username", loggedUserManagementService.getUsername());
           page.addAttribute("loginAttempts", loginCountService.getCount());
           return "main.html";
        }

        return "redirect:/";
    }
}

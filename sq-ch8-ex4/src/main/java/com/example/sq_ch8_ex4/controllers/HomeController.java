package com.example.sq_ch8_ex4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model page, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "color", required = false) String color) {
        page.addAttribute("name", name);
        page.addAttribute("color", color);

        return "home.html";
    }
}

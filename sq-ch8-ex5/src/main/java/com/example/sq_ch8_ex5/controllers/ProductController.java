package com.example.sq_ch8_ex5.controllers;

import com.example.sq_ch8_ex5.models.Product;
import com.example.sq_ch8_ex5.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model page) {
        page.addAttribute("products", productService.getProducts());
        return "products.html";
    }


    // I've could just pass a Product object as a request, and the Spring would create automatically based on the arguments coming
    @PostMapping("/products")
    public String postProduct(Model page, @RequestParam String title, @RequestParam double price) {

        Product p = new Product(title, price);
        productService.addProduct(p);

        var products = productService.getProducts();
        page.addAttribute("products", products);

        return "products.html";
    }
}

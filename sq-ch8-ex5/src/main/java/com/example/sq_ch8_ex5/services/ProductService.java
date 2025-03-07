package com.example.sq_ch8_ex5.services;

import com.example.sq_ch8_ex5.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }
}

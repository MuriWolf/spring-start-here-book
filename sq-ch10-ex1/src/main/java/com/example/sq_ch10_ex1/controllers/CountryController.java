package com.example.sq_ch10_ex1.controllers;

import com.example.sq_ch10_ex1.dto.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> getFrance() {
        Country france = Country.of("France", 68.29D);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("capital", "Paris")
                .header("continent", "Europe")
                .header("favorite_food", "Croissant")
                .body(france);
    }
}

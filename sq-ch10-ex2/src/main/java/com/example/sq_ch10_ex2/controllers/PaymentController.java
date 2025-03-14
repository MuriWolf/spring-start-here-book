package com.example.sq_ch10_ex2.controllers;

import com.example.sq_ch10_ex2.model.PaymentDetails;
import com.example.sq_ch10_ex2.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {

        PaymentDetails paymentDetails = paymentService.processPayment();

        return ResponseEntity.status(HttpStatus.OK).body(paymentDetails);
    }

}

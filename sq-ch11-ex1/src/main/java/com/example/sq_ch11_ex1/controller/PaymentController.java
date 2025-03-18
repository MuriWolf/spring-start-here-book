package com.example.sq_ch11_ex1.controller;

import com.example.sq_ch11_ex1.model.Payment;
import com.example.sq_ch11_ex1.proxy.PaymentProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
       String requestId = UUID.randomUUID().toString();

       return paymentProxy.createPayment(payment, requestId);
    }
}

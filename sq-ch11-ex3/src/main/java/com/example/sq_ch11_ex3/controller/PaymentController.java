package com.example.sq_ch11_ex3.controller;

import com.example.sq_ch11_ex3.model.Payment;
import com.example.sq_ch11_ex3.proxy.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
       String requestId = UUID.randomUUID().toString();
       return paymentProxy.createPayment(payment, requestId);
    }
}

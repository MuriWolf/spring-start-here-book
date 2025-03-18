package com.example.sq_ch11_ex2.proxy;

import com.example.sq_ch11_ex2.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentProxy {

    @Value("${name.service.url}")
    private String serviceUrl;
    private final RestTemplate rest;

    public PaymentProxy(RestTemplate rest) {
        this.rest = rest;
    }

    public Payment createPayment(Payment payment) {
        String serviceUri = serviceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);
        HttpEntity<Payment> response = rest.exchange(serviceUri, HttpMethod.POST, httpEntity, Payment.class);

        return response.getBody();
    }
}

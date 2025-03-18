package com.example.sq_ch11_ex3.proxy;

import com.example.sq_ch11_ex3.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentProxy {

    @Value("${name.service.url}")
    private String serviceUrl;
    private WebClient webClient;

    public PaymentProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(Payment payment, String requestId) {
        return webClient
                .post()
                .uri(serviceUrl + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}

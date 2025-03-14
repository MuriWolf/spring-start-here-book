package com.example.sq_ch10_ex2.services;

import com.example.sq_ch10_ex2.exceptions.NoEnoughMoneyException;
import com.example.sq_ch10_ex2.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment() throws NoEnoughMoneyException {
        throw new NoEnoughMoneyException();
    }
}

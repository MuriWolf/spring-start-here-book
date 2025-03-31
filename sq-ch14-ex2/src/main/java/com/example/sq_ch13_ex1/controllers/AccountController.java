package com.example.sq_ch13_ex1.controllers;

import com.example.sq_ch13_ex1.dtos.TransferRequest;
import com.example.sq_ch13_ex1.models.Account;
import com.example.sq_ch13_ex1.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return transferService.getAllAccounts();
    }

    @PostMapping("transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest) {
        transferService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(), transferRequest.getAmount());
    }
}

package com.example.sq_ch13_ex1.services;

import com.example.sq_ch13_ex1.exceptions.AccountNotFoundException;
import com.example.sq_ch13_ex1.models.Account;
import com.example.sq_ch13_ex1.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
        Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

        if (sender.getAmount().subtract(amount).compareTo(new BigDecimal("0")) == -1) { // < 0 ?
            throw new RuntimeException();
        }

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }
}

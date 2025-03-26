package com.example.sq_ch13_ex1.services;

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

    public List<Account> getAllAccounts() {
        return accountRepository.selectAllAccounts();
    }

    @Transactional
    public void transferMoney(int idSender, int idReceiver, BigDecimal amount) {
        Account sender = accountRepository.selectAccountById(idSender);
        Account receiver = accountRepository.selectAccountById(idReceiver);

        if (sender.getAmount().subtract(amount).compareTo(new BigDecimal("0")) == -1) { // < 0 ?
            throw new RuntimeException();
        }

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }
}

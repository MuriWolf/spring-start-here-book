package com.example.sq_ch13_ex1.dtos;

import java.math.BigDecimal;

public class TransferRequest {
    private long senderId;
    private long receiverId;
    private BigDecimal amount;

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

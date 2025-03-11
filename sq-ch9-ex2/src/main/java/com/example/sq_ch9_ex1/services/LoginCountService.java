package com.example.sq_ch9_ex1.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private int count;

    public void increment() {
        this.count += 1;
    }

    public int getCount() {
        return this.count;
    }
}

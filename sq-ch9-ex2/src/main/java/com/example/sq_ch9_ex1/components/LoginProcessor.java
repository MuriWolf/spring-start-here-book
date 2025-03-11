package com.example.sq_ch9_ex1.components;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final String mockedUsername = "wolfao";
    private final String mockedPassword = "123456";
    private final LoggedUserManagementService loggedUserManagementService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        if (username.equals(mockedUsername) && password.equals(mockedPassword)) {
            loggedUserManagementService.setUsername(username);
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

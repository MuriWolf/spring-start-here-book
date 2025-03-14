package com.example.sq_ch10_ex2.aspects;

import com.example.sq_ch10_ex2.exceptions.NoEnoughMoneyException;
import com.example.sq_ch10_ex2.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NoEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> noEnoughMoneyExceptionHandler() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to do the payment.");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorDetails);
    }
}

package com.metrobank.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.metrobank.account.dto.AccountDto;

@RestControllerAdvice
public class createExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AccountDto> handleValidationErrors(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(err -> err.getDefaultMessage())
            .findFirst()
            .orElse("Validation error");

        AccountDto error = new AccountDto(400, message);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}

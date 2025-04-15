package com.metrobank.account.controller;

import org.springframework.web.bind.annotation.RestController;

import com.metrobank.account.dto.AccountDto;
import com.metrobank.account.model.Account;
import com.metrobank.account.service.AccountService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class createController {

    @Autowired
    AccountService accountService;
    
    @RequestMapping("/")    
    public String initialPage() {
        return "Account creation is running";
    }

    @PostMapping("/api/v1/account")
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody Account account) {
        accountService.createAccount(account);

        return new ResponseEntity<>(
            new AccountDto(account.getCustomerNumber(), 201, "Customer account created"),
            HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/account/{customerNumber}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable int customerNumber) {
        AccountDto response = accountService.getAccountByCustomerNumber(customerNumber);

        HttpStatus status = (response.transactionStatusCode == 302) ? HttpStatus.FOUND : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(response, status);
    }    
}

package com.metrobank.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrobank.account.model.Account;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public void createAccount(Account account) {
        accountRepository.save(account);
    }
    
}

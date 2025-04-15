package com.metrobank.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrobank.account.dto.AccountDto;
import com.metrobank.account.dto.AccountSavingsDto;
import com.metrobank.account.model.Account;
import com.metrobank.account.model.AccountSavings;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SavingsRepository savingsRepository;

    public void createAccount(Account account) {
        AccountSavings accountSavings = new AccountSavings();
        accountSavings.setAccount(account);

        account.setSavings(List.of(accountSavings));
        
        accountRepository.save(account);
    }

    public AccountDto getAccountByCustomerNumber(int customerNumber) {
        Account account = accountRepository.findById(customerNumber)
            .orElse(null);

        if (account == null) {
            AccountDto notFoundDto = new AccountDto();
            notFoundDto.transactionStatusCode = 401;
            notFoundDto.transactionStatusDescription = "Customer not found";
            return notFoundDto;
        }

        AccountDto dto = new AccountDto();
        dto.customerNumber = account.getCustomerNumber();
        dto.customerName = account.getCustomerName();
        dto.customerEmail = account.getCustomerEmail();
        dto.customerMobile = account.getCustomerMobile();
        dto.address1 = account.getAddress1();
        dto.address2 = account.getAddress2();

        dto.savings = account.getSavings().stream().map(s -> {
            AccountSavingsDto accountSavingsDto = new AccountSavingsDto();
            accountSavingsDto.accountNumber =  s.getAccountNumber();
            accountSavingsDto.accountType =  s.getAccountType();
            accountSavingsDto.availableBalance = s.getAvailableBalance();

            return accountSavingsDto;
        }).toList();

        dto.transactionStatusCode = 302;
        dto.transactionStatusDescription = "Customer account found";
        return dto;
    }
}

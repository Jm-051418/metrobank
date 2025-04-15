package com.metrobank.account.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metrobank.account.model.AccountSavings;

public interface SavingsRepository extends JpaRepository<AccountSavings, Integer>{
    List<AccountSavings> findByAccountCustomerNumber(int customerNumber);
}

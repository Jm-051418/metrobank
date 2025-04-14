package com.metrobank.account.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metrobank.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    
}

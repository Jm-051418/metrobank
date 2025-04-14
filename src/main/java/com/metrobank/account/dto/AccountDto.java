package com.metrobank.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Integer accountNumber;
    private int transactionCode;
    private String transactionStatusDescription;

    public AccountDto(Integer accountNumber, int transactionCode, String transactionStatusDescription) {
        this.accountNumber = accountNumber;
        this.transactionCode = transactionCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public AccountDto(int transactionCode, String transactionStatusDescription) {
        this.transactionCode = transactionCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(int transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }


}

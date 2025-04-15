package com.metrobank.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    public Integer customerNumber;

    public String customerName;
    public String customerMobile;
    public String customerEmail;
    public String address1;
    public String address2;

    public List<AccountSavingsDto> savings;

    public int transactionStatusCode;
    public String transactionStatusDescription;

    public AccountDto(){
    }

    public AccountDto(Integer customerNumber, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customerNumber;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public AccountDto(Integer customerNumber, String customerName, String customerMobile, String customerEmail, String address1, String address2, List<AccountSavingsDto> savings, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customerNumber;

        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.customerEmail = customerEmail;
        this.address1 = address1;
        this.address2 = address2;
        this.savings = savings;
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }

    public AccountDto(int transactionStatusCode, String transactionStatusDescription) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }


    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    

    public List<AccountSavingsDto> getSavings() {
        return savings;
    }

    public void setSavings(List<AccountSavingsDto> savings) {
        this.savings = savings;
    }


    public int getTransactionStatusCode() {
        return transactionStatusCode;
    }

    public void setTransactionStatusCode(int transactionStatusCode) {
        this.transactionStatusCode = transactionStatusCode;
    }

    public String getTransactionStatusDescription() {
        return transactionStatusDescription;
    }

    public void setTransactionStatusDescription(String transactionStatusDescription) {
        this.transactionStatusDescription = transactionStatusDescription;
    }


}

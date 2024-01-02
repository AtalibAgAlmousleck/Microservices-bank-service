package com.atalibdev.accountservice.service;

import com.atalibdev.accountservice.entity.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> fetchAccounts();
    BankAccount registerAccount(BankAccount bankAccount);
    BankAccount findAccountById(String accountId);
}

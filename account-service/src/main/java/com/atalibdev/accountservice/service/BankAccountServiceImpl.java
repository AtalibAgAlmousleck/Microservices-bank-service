package com.atalibdev.accountservice.service;

import com.atalibdev.accountservice.entity.BankAccount;
import com.atalibdev.accountservice.exceptions.BankAccountNotFoundException;
import com.atalibdev.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final AccountRepository accountRepository;

    public BankAccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<BankAccount> fetchAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public BankAccount registerAccount(BankAccount bankAccount) {
        String randomUUID = UUID.randomUUID().toString();
        bankAccount.setAccountId(randomUUID);
        bankAccount.setCreatedAt(LocalDateTime.now());
        return accountRepository.save(bankAccount);
    }

    @Override
    public BankAccount findAccountById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotFoundException(
                        "Account with the given id: [%s] not found"
                                .formatted(accountId)
                ));
    }
}

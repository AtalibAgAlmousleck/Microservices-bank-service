package com.atalibdev.accountservice.controler;

import com.atalibdev.accountservice.entity.BankAccount;
import com.atalibdev.accountservice.service.BankAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    public ResponseEntity<List<BankAccount>> fetchAccounts() {
        List<BankAccount> bankAccounts =
                bankAccountService.fetchAccounts();
        return ResponseEntity.ok(bankAccounts);
    }

    @PostMapping
    public ResponseEntity<BankAccount> registerAccount(@RequestBody BankAccount bankAccount) {
        BankAccount savedAccount =
                bankAccountService.registerAccount(bankAccount);
        return ResponseEntity.ok(savedAccount);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<BankAccount> findAccountById(@PathVariable("accountId") String accountId) {
        BankAccount bankAccount = bankAccountService.findAccountById(accountId);
        return ResponseEntity.ok(bankAccount);
    }
}

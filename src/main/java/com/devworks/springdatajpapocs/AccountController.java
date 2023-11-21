package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dstwo.Account;
import com.devworks.springdatajpapocs.dstwo.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accountEntities = accountRepository.findAll();
        return ResponseEntity.ok(accountEntities);
    }

}

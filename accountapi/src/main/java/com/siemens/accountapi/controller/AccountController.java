package com.siemens.accountapi.controller;

import com.siemens.accountapi.model.Account;
import com.siemens.accountapi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/v1.0")
    public ResponseEntity<?> addAccount(@RequestBody Account account) {
        Account account1 = this.accountService.addAccount(account);
        if (account1 != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(account1);
        } else {
            return ResponseEntity.status((HttpStatus.BAD_REQUEST))
                    .body("Account not created");
        }
    }

    @GetMapping("/v1.0")
    public List<Account> getAllAccounts() {
        return this.accountService.getAccounts();
    }
}

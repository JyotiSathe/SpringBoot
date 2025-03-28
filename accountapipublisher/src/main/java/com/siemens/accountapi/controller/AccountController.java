package com.siemens.accountapi.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.siemens.accountapi.model.Account;
import com.siemens.accountapi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/v1.0")
    public CompletableFuture<ResponseEntity<String>> publishAccountDetails(Account account) throws JsonProcessingException {
        return accountService.publishAccountDetails(account)
                .thenApply(result -> ResponseEntity.status(HttpStatus.OK)
                        .body(result.getRecordMetadata().topic() + "," + result.getRecordMetadata().partition() + "," + result.getRecordMetadata().offset()))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
    }
}

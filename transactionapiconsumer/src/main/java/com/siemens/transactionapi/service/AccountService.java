package com.siemens.transactionapi.service;

import com.google.gson.Gson;
import com.siemens.transactionapi.model.Account;
import com.siemens.transactionapi.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(topics = "accountmarch2025", groupId = "saga-account-group")
@Slf4j
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @KafkaHandler(isDefault = true)

    public void consumeAccountDetails(String account) {
        log.info("Consuming account details from topic: " + account);
        Gson gson = new Gson();
        Account account1 = gson.fromJson(account, Account.class);
        //writing the object o mongodb
        this.accountRepository.save(account1);

    }
}
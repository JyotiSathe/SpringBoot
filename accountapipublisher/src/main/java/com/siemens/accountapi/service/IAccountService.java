package com.siemens.accountapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.siemens.accountapi.model.Account;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public interface IAccountService {

    CompletableFuture<SendResult<Object, Object>> publishAccountDetails(Account account) throws JsonProcessingException;
}

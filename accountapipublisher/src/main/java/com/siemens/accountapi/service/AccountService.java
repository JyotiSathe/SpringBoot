package com.siemens.accountapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.javafaker.Faker;
import com.siemens.accountapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AccountService implements IAccountService {

    @Value("${topicname}")
    private String topicName;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    public AccountService(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public CompletableFuture<SendResult<Object, Object>> publishAccountDetails(Account account) throws JsonProcessingException {
        Faker faker = new Faker();
        account.setAccountNumber(faker.number().numberBetween(100000L, 999999L));
        account.setOpenDate(faker.date().birthday().toString());

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(account);
        return kafkaTemplate.send(topicName, json);
    }
}

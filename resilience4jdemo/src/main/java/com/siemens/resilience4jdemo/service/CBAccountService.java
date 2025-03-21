package com.siemens.resilience4jdemo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@Service
@Slf4j
public class CBAccountService {

    @Value("${serviceUrl}")
    private String serviceUrl;

    @Value("${alternativeServiceUrl}")
    private String alternativeServiceUrl;

    private final RestClient restClient;

    @Autowired
    public CBAccountService(RestClient restClient) {
        this.restClient = restClient;
    }

    @CircuitBreaker(name = "gatewayCircuitBreaker", fallbackMethod = "callCBFallbackAccountService")
    @Retry(name = "gatewayRetry")
    public String callCBAccountService() {
        log.info("Entering Primary method @=" + LocalDate.now());
        return restClient.get()
                .uri(serviceUrl)
                .header("Accept", "application/json")
                .retrieve()
                .body(String.class);
    }

    public String callCBFallbackAccountService(Exception e) {
        log.info("Entering Fallback method @=" + LocalDate.now());
        return restClient.get()
                .uri(alternativeServiceUrl)
                .retrieve()
                .body(String.class);
    }
}

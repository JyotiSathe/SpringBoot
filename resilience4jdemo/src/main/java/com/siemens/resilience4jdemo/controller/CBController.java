package com.siemens.resilience4jdemo.controller;


import com.siemens.resilience4jdemo.service.CBAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CBController {

    private final CBAccountService cbAccountService;

    @Autowired
    public CBController(CBAccountService cbAccountService) {
        this.cbAccountService = cbAccountService;
    }


    @GetMapping("/")
    public String getAccountDetails() {
        return cbAccountService.callCBAccountService();
    }
}

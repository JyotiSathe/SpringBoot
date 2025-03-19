package com.siemens.springboottraining.controller;

import com.siemens.springboottraining.dto.CustomerRequest;
import com.siemens.springboottraining.dto.GenericResponse;
import com.siemens.springboottraining.entity.Customer;
import com.siemens.springboottraining.entity.FullName;
import com.siemens.springboottraining.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/v1.0")
    public ResponseEntity<GenericResponse> addCustomer(@Valid @RequestBody CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .customerId(customerRequest.getCustomerId())
                .fullName(FullName.builder()
                        .firstName(customerRequest.getFullName().getFirstName())
                        .build())
                .contactNumber(customerRequest.getContactNumber())
                .email(customerRequest.getEmail())
                .password(customerRequest.getPassword())
                .build();
        Customer customerObj = customerService.addCustomer(customer);

        if (customerObj != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new GenericResponse<>(customerObj));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new GenericResponse<>("Customer not added"));
        }
    }
}

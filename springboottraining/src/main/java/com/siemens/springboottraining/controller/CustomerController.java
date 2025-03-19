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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/v1.0")
    public List<Customer> fetchAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/v1.0/{customerId}")
    public Customer fetchCustomerById(@PathVariable("customerId") long customerId) {
        return this.customerService.getCustomerById(customerId);
    }

    @GetMapping("/v1.0/byContactNumber/{contactNumber}")
    public List<Customer> fetchCustomerByContactNumber(@PathVariable("contactNumber") String contactNumber) {
        return this.customerService.getCustomerByContactNumber(contactNumber);
    }

    @PutMapping("/v1.0")
    public ResponseEntity<GenericResponse> updateCustomerEmail(@RequestParam("customerId") long customerId, @RequestParam("email") String email) {
        Customer customer = this.customerService.updateCustomerEmail(customerId, email);
        if (customer != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new GenericResponse<>(customer));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new GenericResponse<>("Customer email not updated"));
        }
    }

    @PutMapping("/v1.0/updateContact")
    public ResponseEntity<GenericResponse> updateCustomerContactNumber(@RequestParam("customerId") long customerId, @RequestParam("contactNumber") String contactNumber) {
        Customer customer = this.customerService.updateCustomerContactNo(customerId, contactNumber);
        if (customer != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new GenericResponse<>(customer));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new GenericResponse<>("Customer contact number not updated"));
        }
    }

    @DeleteMapping("/v1.0/{customerId}")
    public ResponseEntity<GenericResponse> deleteCustomerById (@PathVariable("customerId") long customerId) {
        if(this.customerService.deleteCustomer(customerId)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new GenericResponse<>("Customer deleted."));
        } else {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                 .body(new GenericResponse<>("Customer not deleted."));
        }
    }

}

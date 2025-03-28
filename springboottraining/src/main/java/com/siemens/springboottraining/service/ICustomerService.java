package com.siemens.springboottraining.service;

import com.siemens.springboottraining.entity.Customer;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(Customer customer);

    Customer updateCustomerEmail(long customerId, String email);

    Customer updateCustomerContactNo(long customerId, String contactNo);

    boolean deleteCustomer(long customerId);

    Customer getCustomerById(long customerId);

    List<Customer> getCustomerByContactNumber(String contactNo);

    List<Customer> getAllCustomers();
}

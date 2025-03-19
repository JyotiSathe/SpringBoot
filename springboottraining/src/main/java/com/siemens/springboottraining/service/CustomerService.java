package com.siemens.springboottraining.service;

import com.siemens.springboottraining.entity.Customer;
import com.siemens.springboottraining.exception.CustomerNotFoundException;
import com.siemens.springboottraining.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomerEmail(long customerId, String email) {
        Customer customer = this.getCustomerById(customerId);
//        customer.setEmail(email);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomerContactNo(long customerId, String contactNo) {
        Customer customer = this.getCustomerById(customerId);
//        customer.setContactNumber(contactNo);
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean deleteCustomer(long customerId) {
        Customer customer = this.getCustomerById(customerId);
        this.customerRepository.delete(customer);
        return this.getCustomerById(customerId) == null;
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return this.customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + customerId + " not found"));
    }

    @Override
    public List<Customer> getCustomerByContactNumber(String contactNo) {
        return this.customerRepository.findByContactNumber(contactNo);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}

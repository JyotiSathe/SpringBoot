package com.siemens.springboottraining.repository;

import com.siemens.springboottraining.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("FROM Customer c WHERE c.contactNumber = :contactNumber")
    List<Customer> findByContactNumber(@Param("contactNumber") String contactNumber);
}

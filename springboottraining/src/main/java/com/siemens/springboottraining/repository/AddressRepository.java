package com.siemens.springboottraining.repository;

import com.siemens.springboottraining.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

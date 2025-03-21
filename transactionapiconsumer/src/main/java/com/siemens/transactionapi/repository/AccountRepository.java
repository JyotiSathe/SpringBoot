package com.siemens.transactionapi.repository;

import com.siemens.transactionapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

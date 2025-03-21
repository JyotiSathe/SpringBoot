package com.siemens.transactionapi.repository;

import com.siemens.transactionapi.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}

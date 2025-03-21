package com.siemens.accountapi.service;

import com.siemens.accountapi.model.Account;

import java.util.List;

public interface IAccountService {

    Account addAccount(Account account);
    List<Account> getAccounts();
}

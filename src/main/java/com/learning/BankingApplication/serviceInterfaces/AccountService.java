package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.entity.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Long customerId, Account account);

    public List<Account> viewAllAccOpenedCustomer(Long customerId);
}

package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.entity.Account;

public interface AccountService {
    public Account createAccount(Long customerId, Account account);
}

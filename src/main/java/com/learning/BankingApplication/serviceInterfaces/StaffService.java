package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.entity.Account;

public interface StaffService {
    public Account approveAccount(Long accountNumber) throws Exception;
}

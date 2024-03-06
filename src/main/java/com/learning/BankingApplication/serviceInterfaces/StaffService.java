package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.entity.Account;

public interface StaffService {
    public boolean approveAccount(Long customerId, Long accountNo) throws Exception;
}

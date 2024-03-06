package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.repository.AccountRepository;
import com.learning.BankingApplication.serviceInterfaces.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final AccountRepository accountRepository;

    //Method for approving the account which is created by the customer
    public boolean approveAccount(Long customerId, Long accountNo) {
        Optional<Account> accountOptional = accountRepository.findByIdAndCustomerId(accountNo, customerId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setApproved("yes");
            accountRepository.save(account);
            return true;
        }
        return false;
    }

}

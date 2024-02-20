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
    public Account approveAccount(Long accountNumber) throws Exception {
        Optional<Account> approvalAccount = accountRepository.findById(accountNumber);
        if(approvalAccount.isPresent()){
            Account account = approvalAccount.get();
            account.setApproved("yes");
            return accountRepository.save(account);
        }
        else{
            throw new Exception("Account not found with account number "+accountNumber);
        }
    }
}

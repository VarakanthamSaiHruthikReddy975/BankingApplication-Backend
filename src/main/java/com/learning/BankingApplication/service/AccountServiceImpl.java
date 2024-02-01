package com.learning.BankingApplication.service;

import com.learning.BankingApplication.repository.AccountRepository;
import com.learning.BankingApplication.serviceInterfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;



}

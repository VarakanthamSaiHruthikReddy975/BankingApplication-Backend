package com.learning.BankingApplication.service;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Customer;
import com.learning.BankingApplication.repository.AccountRepository;
import com.learning.BankingApplication.repository.CustomerRepository;
import com.learning.BankingApplication.serviceInterfaces.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    //End point for creating an account for user
    public Account createAccount(Long customerId, Account account) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            account.setCustomer(customerOptional.get());
            account.setDateOfCreation(new Date()); // Set current date as creation date
            account.setApproved("no"); // Set default approval status
            return accountRepository.save(account);
        } else {
            try {
                throw new Exception("Customer not found with ID: " + customerId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //End point for getting all accounts opened by the customer
    public List<Account> viewAllAccOpenedCustomer(Long customerId){
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accounts;
    }
}

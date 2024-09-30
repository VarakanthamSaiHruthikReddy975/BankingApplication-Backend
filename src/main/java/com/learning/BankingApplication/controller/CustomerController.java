package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Customer;
import com.learning.BankingApplication.repository.CustomerRepository;
import com.learning.BankingApplication.serviceInterfaces.AccountService;
import com.learning.BankingApplication.serviceInterfaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;
    private AccountService accountService;
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO){
        Optional<Customer> customer = customerService.registerCustomer(customerDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerRepository.getCustomerId(customer))
                .toUri();
        return ResponseEntity.created(location).body(customer);
    }

    @PostMapping("/{customerId}/account")
    public ResponseEntity<Account> createAccount(@PathVariable Long customerId, @RequestBody Account account) {
        try {
            // Assume account contains customerId or set it based on the path variable
            Account createdAccount = accountService.createAccount(customerId, account);
            return ResponseEntity.ok(createdAccount);
        } catch (Exception e) {
            return ResponseEntity.status(403).body(null); // Simplified error handling
        }
    }

    @GetMapping("/accounts/customer/{customerId}")
    public ResponseEntity<List<Account>> getAllAccountsByCustomerId(@PathVariable Long customerId) {
        List<Account> accounts = accountService.viewAllAccOpenedCustomer(customerId);
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Optional<List<Customer>>> getAllCustomersById(Long customerId){
        Optional<List<Customer>> customer = customerService.returningCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    // Should update the user customer in the payload which shall match the username and updated the existing customer with the new details.
    @PutMapping("/{customerId}")
    public ResponseEntity<Optional<Customer>> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> updatedCustomer = customerService.updateCustomerbyCustomerId(customerId, customerDTO);
        return ResponseEntity.ok(updatedCustomer);
    }

    // Should get the customer account with the specified account number :accountID
    //When Valid :

    
}

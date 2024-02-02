package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.entity.Customer;
import com.learning.BankingApplication.serviceInterfaces.AccountService;
import com.learning.BankingApplication.serviceInterfaces.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private CustomerService customerService;
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.registerCustomer(customerDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getCustomerId())
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

}

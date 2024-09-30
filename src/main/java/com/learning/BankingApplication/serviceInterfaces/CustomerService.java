package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    //End Point for customer registration
    public Optional<Customer> registerCustomer(CustomerDTO customerDTO);
    public Optional<List<Customer>> returningCustomerById(Long customerId);

    public Optional<Customer> updateCustomerbyCustomerId(Long customerId, CustomerDTO customerDTO);
}

package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Customer;

import java.util.List;

public interface CustomerService {

    //End Point for customer registration
    public Customer registerCustomer(CustomerDTO customerDTO);
    public List<Customer> returningCustomerById(Long customerId);
}

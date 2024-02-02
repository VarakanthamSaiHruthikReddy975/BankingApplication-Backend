package com.learning.BankingApplication.service;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Customer;
import com.learning.BankingApplication.repository.CustomerRepository;
import com.learning.BankingApplication.serviceInterfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public Customer registerCustomer(CustomerDTO customerDTO){
        Customer customer = Customer
                .builder()
                .username(customerDTO.getUsername())
                .full_name(customerDTO.getFull_name())
                .password(customerDTO.getPassword())
                .build();
        return customerRepository.save(customer);
    }

}

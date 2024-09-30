package com.learning.BankingApplication.service;

import com.learning.BankingApplication.dto.CustomerDTO;
import com.learning.BankingApplication.entity.Customer;
import com.learning.BankingApplication.repository.CustomerRepository;
import com.learning.BankingApplication.serviceInterfaces.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public Optional<Customer> registerCustomer(CustomerDTO customerDTO){
        Customer customer = Customer
                .builder()
                .username(customerDTO.getUsername())
                .full_name(customerDTO.getFull_name())
                .password(customerDTO.getPassword())
                .build();
        return Optional.of(customerRepository.save(customer));
    }

    @Override
    public Optional<List<Customer>> returningCustomerById(Long customerId) {

        List<Customer> customer = customerRepository.findAll();
        return Optional.of(customer);
    }

    public Optional<Customer> updateCustomerbyCustomerId(Long customerId, CustomerDTO customerDTO) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        Customer customer = null;
        if (existingCustomer.isPresent()) {
            customer = existingCustomer.get();
            customer.setFull_name(customerDTO.getFull_name());
            customer.setUsername(customerDTO.getUsername());
            customer.setPassword(customerDTO.getPassword()); // Consider encoding password
            customer.setEmail(customerDTO.getEmail());
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
            customer.setAddress(customerDTO.getAddress());
            customer.setDateOfBirth(customerDTO.getDateOfBirth());
            customer.setNationalId(customerDTO.getNationalId());
        }
        Customer savedCustomer = customerRepository.save(customer);
        return Optional.of(savedCustomer);
    }

}

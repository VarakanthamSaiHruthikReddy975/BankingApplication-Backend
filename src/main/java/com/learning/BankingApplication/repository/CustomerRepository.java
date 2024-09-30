package com.learning.BankingApplication.repository;

import com.learning.BankingApplication.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c.id FROM Customer c WHERE c.username = :username")
    Long getCustomerIdByUsername(@Param("username") String username);

    default Long getCustomerId(Optional<Customer> customer) {
        return customer.getCustomerId();
    }
}

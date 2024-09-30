package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    private Long accountNumber;
    private String accountType;
    private Double accountBalance;
    private String approved;
    private Date dateOfCreation;
    @ManyToOne
    @JoinColumn(name="customerId", referencedColumnName = "customerId")
    private Customer customer;
}

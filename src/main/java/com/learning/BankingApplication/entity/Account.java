package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "account")
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountNumber;
    private String accountType;
    private Double accountBalance;
    private String approved;
    private Date dateOfCreation;
    @ManyToOne
    @JoinColumn(name="customerId", referencedColumnName = "customerId")
    private Customer customer;

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account(Long accountNumber, String accountType, Double accountBalance, String approved, Date dateOfCreation, Customer customer) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.approved = approved;
        this.dateOfCreation = dateOfCreation;
        this.customer = customer;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber) && accountType.equals(account.accountType) && accountBalance.equals(account.accountBalance) && approved.equals(account.approved) && dateOfCreation.equals(account.dateOfCreation) && customer.equals(account.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountType, accountBalance, approved, dateOfCreation, customer);
    }
}

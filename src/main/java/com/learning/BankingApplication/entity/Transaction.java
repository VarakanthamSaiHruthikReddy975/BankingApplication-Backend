package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Entity
@Builder
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Date date;
    private String reference;
    private Double amount;
    private String transactionType;
    private Long accountNumber;

    public Transaction(Long transactionId, Date date, String reference, Double amount, String transactionType, Long accountNumber) {
        this.transactionId = transactionId;
        this.date = date;
        this.reference = reference;
        this.amount = amount;
        this.transactionType = transactionType;
        this.accountNumber = accountNumber;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return transactionId.equals(that.transactionId) && date.equals(that.date) && reference.equals(that.reference) && amount.equals(that.amount) && transactionType.equals(that.transactionType) && accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, date, reference, amount, transactionType, accountNumber);
    }
}

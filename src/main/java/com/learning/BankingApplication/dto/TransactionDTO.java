package com.learning.BankingApplication.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Builder
@Data
public class TransactionDTO {
    @NotNull
    @DecimalMin("0.0")
    private Double amount;

    @NotBlank
    @Pattern(regexp = "DEPOSIT|WITHDRAW|TRANSFER")
    private String transactionType;

    @NotNull
    private Long accountNumber;

    @NotNull
    private Long beneficiaryAccountNumber;

    public TransactionDTO(Double amount, String transactionType, Long accountNumber, Long beneficiaryAccountNumber) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.accountNumber = accountNumber;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
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

    public Long getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(Long beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionDTO)) return false;
        TransactionDTO that = (TransactionDTO) o;
        return amount.equals(that.amount) && transactionType.equals(that.transactionType) && accountNumber.equals(that.accountNumber) && beneficiaryAccountNumber.equals(that.beneficiaryAccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionType, accountNumber, beneficiaryAccountNumber);
    }

    public TransactionDTO() {
    }
}

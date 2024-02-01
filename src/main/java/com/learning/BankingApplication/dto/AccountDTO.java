package com.learning.BankingApplication.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Builder
@Component
@Data
public class AccountDTO {

    @NotBlank
    @Size(min = 2, max = 50)
    private String accountType;

    @NotNull
    @DecimalMin("0.0")
    private Double accountBalance;

    @NotNull
    private Long customerId;




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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public AccountDTO(String accountType, Double accountBalance, Long customerId) {
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDTO)) return false;
        AccountDTO that = (AccountDTO) o;
        return accountType.equals(that.accountType) && accountBalance.equals(that.accountBalance) && customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, accountBalance, customerId);
    }
}

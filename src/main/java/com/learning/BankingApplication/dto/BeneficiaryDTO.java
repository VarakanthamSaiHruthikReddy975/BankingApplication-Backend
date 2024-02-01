package com.learning.BankingApplication.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Builder
@Data
public class BeneficiaryDTO {

    @NotNull
    private Long beneficiaryAccountNo;

    @NotBlank
    private String beneficiaryName;

    @NotNull
    private Long customerID;

    public Long getBeneficiaryAccountNo() {
        return beneficiaryAccountNo;
    }

    public void setBeneficiaryAccountNo(Long beneficiaryAccountNo) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public BeneficiaryDTO(Long beneficiaryAccountNo, String beneficiaryName, Long customerID) {
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryName = beneficiaryName;
        this.customerID = customerID;
    }

    public BeneficiaryDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeneficiaryDTO)) return false;
        BeneficiaryDTO that = (BeneficiaryDTO) o;
        return beneficiaryAccountNo.equals(that.beneficiaryAccountNo) && beneficiaryName.equals(that.beneficiaryName) && customerID.equals(that.customerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficiaryAccountNo, beneficiaryName, customerID);
    }
}

package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "beneficiary")
@Builder
@Data
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long beneficiaryId;
    private Long beneficiaryAccountNo;
    private String beneficiaryName;
    private String active;
    private Long customerId;

    public Beneficiary(Long beneficiaryId, Long beneficiaryAccountNo, String beneficiaryName, String active, Long customerId) {
        this.beneficiaryId = beneficiaryId;
        this.beneficiaryAccountNo = beneficiaryAccountNo;
        this.beneficiaryName = beneficiaryName;
        this.active = active;
        this.customerId = customerId;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficiary)) return false;
        Beneficiary that = (Beneficiary) o;
        return beneficiaryId.equals(that.beneficiaryId) && beneficiaryAccountNo.equals(that.beneficiaryAccountNo) && beneficiaryName.equals(that.beneficiaryName) && active.equals(that.active) && customerId.equals(that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficiaryId, beneficiaryAccountNo, beneficiaryName, active, customerId);
    }
}

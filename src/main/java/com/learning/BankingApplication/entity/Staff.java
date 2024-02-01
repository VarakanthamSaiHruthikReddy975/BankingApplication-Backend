package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "staff")
@Builder
@Data
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staffId;
    private String staffName;
    private String staffUsername;
    private String staffPassword;
    private String status;

    public Staff(Long staffId, String staffName, String staffUsername, String staffPassword, String status) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.status = status;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Staff() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return staffId.equals(staff.staffId) && staffName.equals(staff.staffName) && staffUsername.equals(staff.staffUsername) && staffPassword.equals(staff.staffPassword) && status.equals(staff.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffUsername, staffPassword, status);
    }
}

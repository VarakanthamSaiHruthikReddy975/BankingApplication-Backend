package com.learning.BankingApplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Builder
@Data
public class StaffDTO {
    @NotBlank
    @Size(min = 5, max = 20) // Example range, adjust as needed
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$")
    private String staffUsername;

    @NotBlank
    private String staffPassword;

    @NotBlank
    private String status;

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

    public StaffDTO(String staffUsername, String staffPassword, String status) {
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
        this.status = status;
    }

    public StaffDTO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffDTO)) return false;
        StaffDTO staffDTO = (StaffDTO) o;
        return staffUsername.equals(staffDTO.staffUsername) && staffPassword.equals(staffDTO.staffPassword) && status.equals(staffDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffUsername, staffPassword, status);
    }
}

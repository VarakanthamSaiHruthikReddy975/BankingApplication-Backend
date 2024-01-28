package com.learning.BankingApplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "customer")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String full_name;
    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String address;
    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate dateOfBirth;

    @NotBlank
    private String nationalId;

    private String accountStatus;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime lastLogin;
    @Column(columnDefinition = "DATE")
    private LocalDate joinedDate;
    private String securityQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public Customer(Long id, String username, String full_name, String password, String email, String phoneNumber, String address, LocalDate dateOfBirth, String nationalId, String accountStatus, LocalDateTime lastLogin, LocalDate joinedDate, String securityQuestion) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.nationalId = nationalId;
        this.accountStatus = accountStatus;
        this.lastLogin = lastLogin;
        this.joinedDate = joinedDate;
        this.securityQuestion = securityQuestion;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalId='" + nationalId + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", lastLogin=" + lastLogin +
                ", joinedDate=" + joinedDate +
                ", securityQuestion='" + securityQuestion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && username.equals(customer.username) && full_name.equals(customer.full_name) && password.equals(customer.password) && email.equals(customer.email) && phoneNumber.equals(customer.phoneNumber) && address.equals(customer.address) && dateOfBirth.equals(customer.dateOfBirth) && nationalId.equals(customer.nationalId) && accountStatus.equals(customer.accountStatus) && lastLogin.equals(customer.lastLogin) && joinedDate.equals(customer.joinedDate) && securityQuestion.equals(customer.securityQuestion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, full_name, password, email, phoneNumber, address, dateOfBirth, nationalId, accountStatus, lastLogin, joinedDate, securityQuestion);
    }
}

package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.serviceInterfaces.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    //Endpoint for approving customer based on customer id

    @PutMapping("/customer/{customerId}/account/{accountNo}/approve")
    public ResponseEntity<?> approveAccount(@PathVariable Long customerId, @PathVariable Long accountNo) throws Exception {
        boolean isApproved = staffService.approveAccount(customerId, accountNo);
        if (isApproved) {
            return ResponseEntity.ok().body("Account successfully approved.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

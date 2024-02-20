package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.entity.Account;
import com.learning.BankingApplication.serviceInterfaces.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;


    //Endpoint for approving customer based on customer id
    public ResponseEntity<?> staffApproveCustomer(Long accountNumber) throws Exception {
        try{
            Account account = staffService.approveAccount(accountNumber);
            return ResponseEntity.ok(account);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}

package com.learning.BankingApplication.controller;

import com.learning.BankingApplication.dto.LoginResponseDTO;
import com.learning.BankingApplication.dto.RegistrationDTO;
import com.learning.BankingApplication.entity.ApplicationUser;
import com.learning.BankingApplication.serviceInterfaces.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO registrationDTO){
        return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }

}
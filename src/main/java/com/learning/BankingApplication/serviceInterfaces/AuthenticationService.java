package com.learning.BankingApplication.serviceInterfaces;

import com.learning.BankingApplication.dto.LoginResponseDTO;
import com.learning.BankingApplication.entity.ApplicationUser;

public interface AuthenticationService {

    public ApplicationUser registerUser(String username, String password);
    public LoginResponseDTO loginUser(String username, String password);
}

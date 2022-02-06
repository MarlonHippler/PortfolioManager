package com.apple.PortfolioManager.service;

import com.apple.PortfolioManager.Request.LogInRequest;
import com.apple.PortfolioManager.model.AppUserRole;
import com.apple.PortfolioManager.model.UserApp;
import com.apple.PortfolioManager.registration.EmailValidator;
import com.apple.PortfolioManager.registration.RegistrationRequest;
import com.apple.PortfolioManager.repo.UserRepo;
import com.apple.PortfolioManager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogInService {

    private final UserRepo userRepo;


    public void login(LogInRequest request) {
        if ( !true == userRepo.findByUsername(request.getUsername()).get().getUsername().equals(request.username)
                && userRepo.findByUsername(request.getUsername()).get().getPassword().equals(request.password)){
            throw new IllegalStateException("Die Angaben stimmen nicht überein");
        }



    }
}

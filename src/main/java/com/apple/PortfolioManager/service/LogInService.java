package com.apple.PortfolioManager.service;

import com.apple.PortfolioManager.Request.LogInRequest;
import com.apple.PortfolioManager.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogInService {

    private final UserRepo userRepo;


    public String login(LogInRequest request) {


        if ( !userRepo.findByUsername(request.getUsername()).get().getUsername().equals(request.username)
                && userRepo.findByUsername(request.getUsername()).get().getPassword().equals(request.password)){
            throw new IllegalStateException("Die Angaben stimmen nicht überein");
        }
        return "it wooarks";



    }
}

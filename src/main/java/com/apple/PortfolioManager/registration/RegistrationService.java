package com.apple.PortfolioManager.registration;

import com.apple.PortfolioManager.model.AppUserRole;
import com.apple.PortfolioManager.model.UserApp;
import com.apple.PortfolioManager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final UserService userService;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }

        return userService.registerUser(
                new UserApp(
                      request.getName(),
                      request.getEmail(),
                      request.getPassword(),
                      AppUserRole.USER

                )
        );
    }
}
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
        boolean isValidEmail = emailValidator.test(request.getUsername());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }
        UserApp user= new UserApp();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setEnabled(true);
        user.setLocked(false);
        user.setAppUserRole(AppUserRole.USER);
        return userService.registerUser(
              user
        );
    }
}

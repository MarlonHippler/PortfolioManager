package com.apple.PortfolioManager.controller;


import com.apple.PortfolioManager.Request.LogInRequest;
import com.apple.PortfolioManager.Security.config.JWTTokenHelper;
import com.apple.PortfolioManager.model.LoginResponse;
import com.apple.PortfolioManager.model.UserApp;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/v1/login")
@AllArgsConstructor
public class LogInController {

    @Autowired
    private JWTTokenHelper jwtTokenHelper;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping

    public ResponseEntity<LoginResponse> logIn(@RequestBody LogInRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException {
        try {
            final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserApp user = (UserApp) authentication.getPrincipal();
            String jwtToken = jwtTokenHelper.generateToken(user.getUsername());

            LoginResponse response = new LoginResponse();
            response.setToken(jwtToken);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ERROR");
        }
    }
}

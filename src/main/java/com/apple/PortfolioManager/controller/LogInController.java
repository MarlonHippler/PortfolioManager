package com.apple.PortfolioManager.controller;


import com.apple.PortfolioManager.Request.LogInRequest;
import com.apple.PortfolioManager.service.LogInService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/v1/login")
@RestController
@AllArgsConstructor
public class LogInController {

    private LogInService logInService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String logIn(@RequestBody LogInRequest request){


        return logInService.login(request);
    }


}

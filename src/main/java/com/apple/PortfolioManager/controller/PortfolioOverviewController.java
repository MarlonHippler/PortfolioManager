
package com.apple.PortfolioManager.controller;


import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.Security.config.JWTTokenHelper;
import com.apple.PortfolioManager.service.PortfolioOverviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@CrossOrigin(origins = "http://localhost:4200")
        @RestController
@RequestMapping(path="api/v1/createPortfolio")
        @AllArgsConstructor
        public class PortfolioOverviewController {


        private PortfolioOverviewService portfolioOverviewService;

        @PostMapping
        //@ResponseStatus(HttpStatus.OK)
        public void createPortfolio(@RequestBody PortfolioRequest request)  {

        portfolioOverviewService.newPortfolio(request);

        }

        }

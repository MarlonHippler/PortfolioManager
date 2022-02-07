package com.apple.PortfolioManager.controller;

import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.Request.StockRequest;

import com.apple.PortfolioManager.service.PortfolioOverviewService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/createPortfolio")
@AllArgsConstructor
public class PortfolioOverviewController {


    private PortfolioOverviewService portfolioOverviewService;

    @PostMapping
    public void createPortfolio(@RequestBody PortfolioRequest request){
        portfolioOverviewService.newPortfolio(request);
    }




}


package com.apple.PortfolioManager.controller;

import com.apple.PortfolioManager.Request.StockRequest;
import com.apple.PortfolioManager.service.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path= "api/v1/buyStock")
@RestController
@AllArgsConstructor

public class PortfolioBuyController {

    private PortfolioService portfolioService;

    @PostMapping
    public void buyStock(@RequestBody StockRequest request){


        portfolioService.buyStock(request);
    }


}


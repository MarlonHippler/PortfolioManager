package com.apple.PortfolioManager.service;

import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.model.Portfolio;
import com.apple.PortfolioManager.repo.PortfolioRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PortfolioOverviewService {

    PortfolioRepo portfolioRepo;


    public void newPortfolio(PortfolioRequest request) {

        String string = request.getPortfolioName();

        portfolioRepo.save(new Portfolio(string));


    }
}


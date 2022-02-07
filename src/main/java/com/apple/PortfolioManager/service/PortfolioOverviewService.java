package com.apple.PortfolioManager.service;

/**
 * Klasse Service für Overview
 *
 * @author  Marlon Hippler
 */
import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.model.Portfolio;
import com.apple.PortfolioManager.repo.PortfolioOverviewRepo;
import com.apple.PortfolioManager.repo.PortfolioRepo;
import com.apple.PortfolioManager.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class PortfolioOverviewService {

    PortfolioOverviewRepo portfolioOverviewRepo;
    UserRepo userRepo;
    PortfolioRepo portfolioRepo;



    public void newPortfolio(PortfolioRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = ((UserDetails)auth.getPrincipal()).getUsername();
        ;;
        Long id = userRepo.findByUsername(nameUser).get().getId();


        if (portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().contains(request.getPortfolioName())) {
            throw new IllegalStateException("You can not use a portfolio name twice");
        } else {
            Portfolio portfolio = new Portfolio();
            portfolio.setNamePortfolio(request.getPortfolioName());
            portfolioRepo.save(portfolio);
            portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().add(portfolio);
        }
    }

    public void deletePortfolio(PortfolioRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = auth.getPrincipal().toString();
        Long id = userRepo.findByUsername(nameUser).get().getId();

        int positionPortfolio = findPortfolioByName(request, id);


        if (positionPortfolio < 0) {
            throw new IllegalStateException("Portfolio not found");
        } else {

            int portfolioEmpty = portfolioEmpty(positionPortfolio,id);
            if (portfolioEmpty>=0){
                throw new IllegalStateException("Portfolio not empty");
            }else{
                portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().remove(positionPortfolio);
            }


        }
    }


    public int findPortfolioByName(PortfolioRequest request, Long id) {
        for (int i = 0; i < portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().size(); i++) {
            if (portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(i).getNamePortfolio().equals(request.getPortfolioName())) {
                return i;
            }
        }
        return -1;
    }

    public int portfolioEmpty(int positionPortfolio, Long id) {
        for (int i = 0; i < portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(positionPortfolio).getArrayOfStocks().size(); i++) {
            if (portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(positionPortfolio).getArrayOfStocks().get(i).getStueckzahlStock() > 0) {
                return i;
            }
        }
        return -1;


    }
}

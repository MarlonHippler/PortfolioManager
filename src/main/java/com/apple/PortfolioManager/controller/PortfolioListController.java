package com.apple.PortfolioManager.controller;

import com.apple.PortfolioManager.model.Portfolio;
import com.apple.PortfolioManager.repo.PortfolioRepo;
import com.apple.PortfolioManager.repo.Portfolio_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
    public class PortfolioListController {

        @Autowired
        private Portfolio_DAO eRepo;

        @GetMapping(path= "api/v1/listPortfolios")
        public List<Portfolio> viewAllPortfolio(){

            return (List<Portfolio>)eRepo.viewPortfolios();
        }
    }


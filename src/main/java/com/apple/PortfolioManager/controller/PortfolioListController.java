package com.apple.PortfolioManager.controller;

import com.apple.PortfolioManager.repo.PortfolioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



    @Controller
    public class PortfolioListController {

        @Autowired
        private PortfolioRepo eRepo;

        @GetMapping({"/list"})
        public ModelAndView getAllPortfolios() {
            ModelAndView mav = new ModelAndView("list-portfolios");
            mav.addObject("portfolios", eRepo.findAll());
            return mav;
        }
    }


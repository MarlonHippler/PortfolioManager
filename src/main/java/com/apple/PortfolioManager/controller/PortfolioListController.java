package com.apple.PortfolioManager.controller;

import java.util.List;

import com.apple.PortfolioManager.model.Portfolio;
import com.apple.PortfolioManager.service.PortfolioListService;
import com.apple.PortfolioManager.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller für List
 *
 * @author  Marlon Hippler
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")

public class PortfolioListController {


    private PortfolioListService portfolioListService;



    @GetMapping("api/v1/listPortfolios")
    public List<Portfolio> allportfolios() {
        return this.portfolioListService.getPortfolios();

    }

    @DeleteMapping("api/v1/deletePortfolio/{id_portfolio}")
    public boolean deletePortfolio(@PathVariable("id_portfolio") long idPortfolio, Portfolio portfolio) {
        portfolio.setIdPortfolio(idPortfolio);
        return this.portfolioListService.deletePortfolio(portfolio);
    }


}

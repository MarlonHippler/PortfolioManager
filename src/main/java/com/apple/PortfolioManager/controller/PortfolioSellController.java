
        package com.apple.PortfolioManager.controller;

import com.apple.PortfolioManager.Request.StockRequest;
import com.apple.PortfolioManager.Request.StockRequestVerkauf;
import com.apple.PortfolioManager.service.PortfolioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

        /**
         * Controller für Sell
         *
         * @author  Marlon Hippler
         * */
@CrossOrigin(origins = "http://localhost:4200/")
        @RequestMapping(path= "api/v1/sellStock")
        @RestController
@AllArgsConstructor
        public class PortfolioSellController {

        private PortfolioService portfolioService;

        @PostMapping
        public void sellStock(@RequestBody StockRequestVerkauf request){


        portfolioService.sellStock(request);
        }


        }

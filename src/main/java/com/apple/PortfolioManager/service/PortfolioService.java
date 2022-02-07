package com.apple.PortfolioManager.service;

import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.Request.StockRequest;
import com.apple.PortfolioManager.Request.StockRequestVerkauf;
import com.apple.PortfolioManager.model.Stock;
import com.apple.PortfolioManager.repo.PortfolioRepo;
import com.apple.PortfolioManager.repo.StockRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PortfolioService {

    StockRepo stockRepo;
    PortfolioRepo   portfolioRepo;


    public void buyStock(StockRequest request) {

       if (stockRepo.findByWKNStock(request.getWKNStock()).isPresent()){
           int anzahlAlt = stockRepo.findByWKNStock(request.getWKNStock()).get().getStueckzahlStock();
           int anzahlNeu = anzahlAlt + request.getStueckzahlStock();
           stockRepo.findByWKNStock(request.getWKNStock()).get().setStueckzahlStock(anzahlNeu);
       }else{
           Stock stock = new Stock();
           stock.setWKNStock(request.getWKNStock());
           stock.setNameStock(request.getNameStock());
           stock.setArtWertpapierStock(request.getArtWertpapierStock());
           stock.setStueckzahlStock(request.getStueckzahlStock());
           int anzahl= request.getStueckzahlStock();
//TODO eine iteration einführen
           portfolioRepo.findByNamePortfolio(request.getPortfolioName()).get().getArrayOfStocks().add(0,new Stock(stock.nameStock, stock.WKNStock, stock.artWertpapierStock, anzahl));


       }
    }

    public void sellStock(StockRequestVerkauf request){
        int anzahl = stockRepo.findByWKNStock(request.getWKNStock()).get().getStueckzahlStock();
        if (anzahl < request.getStueckzahlStock()){
            throw new IllegalStateException("Sell amount too high.");

        } else {
            int anzahlneu = anzahl - request.getStueckzahlStock();
            stockRepo.findByWKNStock(request.getWKNStock()).get().setStueckzahlStock(anzahlneu);
        }
    }


}



package com.apple.PortfolioManager.service;

import com.apple.PortfolioManager.Request.PortfolioRequest;
import com.apple.PortfolioManager.Request.StockRequest;
import com.apple.PortfolioManager.Request.StockRequestVerkauf;
import com.apple.PortfolioManager.model.PortfolioOverview;
import com.apple.PortfolioManager.model.Stock;
import com.apple.PortfolioManager.repo.PortfolioOverviewRepo;
import com.apple.PortfolioManager.repo.PortfolioRepo;
import com.apple.PortfolioManager.repo.StockRepo;
import com.apple.PortfolioManager.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PortfolioService {

    StockRepo stockRepo;
    PortfolioRepo   portfolioRepo;
    PortfolioOverviewRepo portfolioOverviewRepo;
    UserRepo    userRepo;



    public int findPositionByPortfolioe(StockRequest request, Long id){
        for(int i = 0; i< portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().size(); i++){
            if(portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(i).getNamePortfolio().equals(request.getPortfolioName())){
                return i;
            }
        } return -1;
    }

    public int findPositionByWKN(StockRequest request, int j, Long id){
        for(int i = 0; i< portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(j).getArrayOfStocks().size(); i++){
            if(portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(j).getArrayOfStocks().get(i).getWKNStock().equals(request.getWKNStock())){
                return i;
            }
        } return -1;
    }


    public void buyStock(StockRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = auth.getPrincipal().toString();
        Long id = userRepo.findByUsername(nameUser).get().getId();


        int positionPortfolio = findPositionByPortfolioe(request,id);
        int positionStockNachWKN = findPositionByWKN(request,positionPortfolio,id );


        if (positionPortfolio<0){
            throw new IllegalStateException("Portfolio not found.");
        }else{
            if (positionStockNachWKN<0){
                Stock stock = new Stock();
                stock.setNameStock(request.getNameStock());
                stock.setWKNStock(request.getWKNStock());
                stock.setArtWertpapierStock(request.getArtWertpapierStock());
                stock.setStueckzahlStock(request.getStueckzahlStock());
                stockRepo.save(stock);
            }else{
                int alteStueckzahl = portfolioOverviewRepo.findById(id).get()
                        .getArrayOfPortfolios()
                        .get(positionPortfolio)
                        .getArrayOfStocks()
                        .get(positionStockNachWKN)
                        .getStueckzahlStock();
                int neueStueckzahl = alteStueckzahl + request.getStueckzahlStock();


                portfolioOverviewRepo.findById(id).get()
                        .getArrayOfPortfolios()
                        .get(positionPortfolio)
                        .getArrayOfStocks()
                        .get(positionStockNachWKN)
                        .setStueckzahlStock(neueStueckzahl);
            }
        }



    }

    public void sellStock(StockRequestVerkauf request) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nameUser = auth.getPrincipal().toString();
        Long id = userRepo.findByUsername(nameUser).get().getId();

        int positionPortfolio = findPositionByPortfolioe(request,id);
        int positionStockNachWKN = findPositionByWKN(request,positionPortfolio,id );


        if (positionPortfolio<0){
            throw new IllegalStateException("Portfolio not found.");
        }else{
            if (positionStockNachWKN<0){
                throw new IllegalStateException("WKN not found");
            }else{
                int alteStueckzahl = portfolioOverviewRepo.findById(id).get()
                        .getArrayOfPortfolios()
                        .get(positionPortfolio)
                        .getArrayOfStocks()
                        .get(positionStockNachWKN)
                        .getStueckzahlStock();
                int neueStueckzahl = alteStueckzahl - request.getStueckzahlStock();
                if(neueStueckzahl<0){
                    throw new IllegalStateException("Sell amount too high");
                }else {
                    portfolioOverviewRepo.findById(id).get()
                            .getArrayOfPortfolios()
                            .get(positionPortfolio)
                            .getArrayOfStocks()
                            .get(positionStockNachWKN)
                            .setStueckzahlStock(neueStueckzahl);
                }
            }
        }





    }

    public int findPositionByPortfolioe(StockRequestVerkauf request, Long id){
        for(int i = 0; i< portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().size(); i++){
            if(portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(i).getNamePortfolio().equals(request.getPortfolioName())){
                return i;
            }
        } return -1;
    }

    public int findPositionByWKN(StockRequestVerkauf request, int j, Long id){
        for(int i = 0; i< portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(j).getArrayOfStocks().size(); i++){
            if(portfolioOverviewRepo.findById(id).get().getArrayOfPortfolios().get(j).getArrayOfStocks().get(i).getWKNStock().equals(request.getWKNStock())){
                return i;
            }
        } return -1;
    }
}






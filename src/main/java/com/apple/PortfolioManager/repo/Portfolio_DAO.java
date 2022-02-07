package com.apple.PortfolioManager.repo;


import java.util.List;


import com.apple.PortfolioManager.model.Portfolio;

public interface Portfolio_DAO {

    public boolean savePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolios();
    public boolean deletePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolioByID(Portfolio portfolio);

}
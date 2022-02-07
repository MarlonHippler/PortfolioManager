package com.apple.PortfolioManager.service;
import com.apple.PortfolioManager.model.Portfolio;

import java.util.List;






public interface PortfolioListService {
    public boolean savePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolios();
    public boolean deletePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolioByID(Portfolio portfolio);
    public boolean updatePortfolio(Portfolio portfolio);
}



package com.apple.PortfolioManager.service;
import com.apple.PortfolioManager.model.Portfolio;

import java.util.List;

/**
 * Klasse Service für PortfolioList
 *
 * @author  Marc Wortmann, Franzi Aroro
 */
public interface PortfolioListService {
    public boolean savePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolios();
    public boolean deletePortfolio(Portfolio portfolio);
    public List<Portfolio> getPortfolioByID(Portfolio portfolio);

}



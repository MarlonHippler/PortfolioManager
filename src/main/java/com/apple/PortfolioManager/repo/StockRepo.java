package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Long >{

}

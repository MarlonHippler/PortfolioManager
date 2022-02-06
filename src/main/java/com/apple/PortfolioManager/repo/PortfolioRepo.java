package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio, Long> {
}

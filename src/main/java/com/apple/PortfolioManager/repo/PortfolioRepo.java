package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repo für Portfolio
 *
 * @author  Marlon Hippler
 */
@Repository
public interface PortfolioRepo extends JpaRepository<Portfolio, Long> {

    Optional<Portfolio> findByNamePortfolio(String name);




}


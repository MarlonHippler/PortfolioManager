package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.PortfolioOverview;
import com.apple.PortfolioManager.model.Stock;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioOverviewRepo extends JpaRepository<PortfolioOverview, Long> {
    Optional<PortfolioOverview> findById(Long name);
}


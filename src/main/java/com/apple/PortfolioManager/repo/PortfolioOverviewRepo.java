package com.apple.PortfolioManager.repo;

import com.apple.PortfolioManager.model.PortfolioOverview;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioOverviewRepo extends JpaRepository<PortfolioOverview, Long> {
}

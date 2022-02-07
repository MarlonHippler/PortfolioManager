package com.apple.PortfolioManager.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.apple.PortfolioManager.model.Portfolio;
import org.springframework.stereotype.Repository;



@Repository
public class Portfolio_DAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Portfolio> viewPortfolios()
    {
        Query query = entityManager.createNativeQuery("select * from portfolio", Portfolio.class);
        return (List<Portfolio>)query.getResultList();
    }
}
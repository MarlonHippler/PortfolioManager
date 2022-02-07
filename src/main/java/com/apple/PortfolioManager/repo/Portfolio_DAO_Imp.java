package com.apple.PortfolioManager.repo;
import java.util.List;


import com.apple.PortfolioManager.model.Portfolio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repo für Portfolio_DAO_Imp
 *
 * @author  Franzi Arora, Marc Wortmann
 */
@Repository
public class Portfolio_DAO_Imp  implements Portfolio_DAO {


    private SessionFactory sessionFactory;

    @Override
    public boolean savePortfolio(Portfolio portfolio) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().save(portfolio);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Portfolio> getPortfolios() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Portfolio> query=currentSession.createQuery("from Portfolio", Portfolio.class);
        List<Portfolio> list=query.getResultList();
        return list;
    }

    @Override
    public boolean deletePortfolio(Portfolio student) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().delete(student);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Portfolio> getPortfolioByID(Portfolio portfolio) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Portfolio> query=currentSession.createQuery("from Portfolio where idPortfolio=:id_portfolio", Portfolio.class);
        query.setParameter("id_portfolio", portfolio.getIdPortfolio());
        List<Portfolio> list=query.getResultList();
        return list;
    }


}




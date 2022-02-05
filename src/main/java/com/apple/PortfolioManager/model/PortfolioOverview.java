package com.apple.PortfolioManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PortfolioOverview implements Serializable {

    @Id
    private Long id;

    @OneToMany
    public List<Portfolio> arrayOfPortfolios;



    public PortfolioOverview() {
        this.arrayOfPortfolios = new ArrayList<>();
    }


    public void addPortfolio(String name) {

        if (findPositionByName(name) < 0){

            arrayOfPortfolios.add(new Portfolio(name));

        }else{
            System.out.println("Doppelte Namen von Portfolios sind nicht zulässig.");
        }
    }

    public void deletePortfolio(String name) {

        //check ob noch Positionen drin sind
        //löschen
        int keinDelete = 0;
        int indexNumberPortfolio = findPositionByName(name);
        int size = getArrayOfPortfolios().get(indexNumberPortfolio).getArrayOfStocks().size();
        if(size == 0){
            getArrayOfPortfolios().remove(indexNumberPortfolio);
            System.out.println(name + "wurde gelöscht");
        } else {

            for (int i = 0; i < size; i++) {
                if (getArrayOfPortfolios().get(indexNumberPortfolio).getArrayOfStocks().get(i).getStueckzahlPortfolio() > 0) {

                    System.out.println(name+" kann nicht gelöscht werden, es befinden sich noch Positionen im Portfolio.");
                    keinDelete = 1;
                    break;
                }


            }
            if (keinDelete<1) {
                getArrayOfPortfolios().remove(indexNumberPortfolio);
                System.out.println(name + "wurde gelöscht");
            }
        }
    }




    public int findPositionByName(String name) {
        for (int i = 0; i < arrayOfPortfolios.size(); i++) {
            if (arrayOfPortfolios.get(i).getNamePortfolio().equals(name)) {
                return i;
            }
        }return -1;}

    public List<Portfolio> getArrayOfPortfolios() {
        return arrayOfPortfolios;
    }

    public void setArrayOfPortfolios(ArrayList<Portfolio> arrayOfPortfolios) {
        arrayOfPortfolios = arrayOfPortfolios;
    }


    public void moveStock(String ursprungPortfolio, String zielPortfolio, String WKN, int stueckzahl) {
        //Check ist noch was da
        int indexUrsprungPortfolio = findPositionByName(ursprungPortfolio);
        int indexZielportfolio = findPositionByName(zielPortfolio);
        int indexUrsprungStock = getArrayOfPortfolios().get(indexUrsprungPortfolio).findPositionByWKN(WKN);
        int stueckzahlUrsprung = getArrayOfPortfolios().get(indexUrsprungPortfolio).getArrayOfStocks().get(indexUrsprungStock).getStueckzahlPortfolio();
        if (stueckzahlUrsprung >= stueckzahl) {
            getArrayOfPortfolios().get(indexZielportfolio).buyStock
                    (getArrayOfPortfolios().get(indexUrsprungPortfolio).getArrayOfStocks().get(indexUrsprungStock).getNamePortfolio(),
                            WKN,
                            getArrayOfPortfolios().get(indexUrsprungPortfolio).getArrayOfStocks().get(indexUrsprungStock).getArtWertpapierPortfolio(),
                            getArrayOfPortfolios().get(indexUrsprungPortfolio).getArrayOfStocks().get(indexUrsprungStock).getStueckzahlPortfolio());
            getArrayOfPortfolios().get(indexUrsprungPortfolio).sellStock(WKN,stueckzahl);


        }else{
            System.out.println("Die Aktie ist nicht und nur in zu geringem Maße im Ursprungsportfolio vorhanden.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArrayOfPortfolios(List<Portfolio> arrayOfPortfolios) {
        this.arrayOfPortfolios = arrayOfPortfolios;
    }
}

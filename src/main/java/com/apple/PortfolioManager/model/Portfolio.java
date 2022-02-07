package com.apple.PortfolioManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name=portfolio)
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPortfolio;
    public  String namePortfolio;
    @OneToMany
    public List<Stock> arrayOfStocks;

    public Portfolio(String name){
        namePortfolio = name;
        this.arrayOfStocks = new ArrayList<Stock>();
    }

    public Portfolio() {

    }


    //Findet die Position der Übereinstimmung der WKN in einer ArrayList
    public int findPositionByWKN(String WKN){
        for(int i = 0; i< arrayOfStocks.size(); i++){
            if(arrayOfStocks.get(i).getWKNStock().equals(WKN)){
                return i;
            }
        } return -1;

    }

    //kauft eine Aktie, überprüft ob Aktie schon vorhanden, falls vorhanden nur Hinzufügen, falls nicht neue Position

    public void buyStock(String name,String WKN, String artWertpapier,int stueckzahl){
        //int indexNumberUebersicht = getIndexFromClient
        if(findPositionByWKN(WKN) >= 0){
            int indexNumber = findPositionByWKN(WKN);
            int stueckzahlAlt = arrayOfStocks.get(indexNumber).getStueckzahlStock();
            if(stueckzahlAlt >= 0) {
                int neueStueckzahl = stueckzahlAlt + stueckzahl;
                arrayOfStocks.get(indexNumber).setStueckzahlStock(neueStueckzahl);
            }}
        else
            arrayOfStocks.add(new Stock(name,WKN,artWertpapier,stueckzahl));}



    //verkauft eine Aktie, checkt vorher ob genügend da ist

    public void sellStock(String WKN,int stueckzahl){
        if(findPositionByWKN(WKN) >= 0){
            int indexNumber = findPositionByWKN(WKN);
            int stueckzahlAlt = arrayOfStocks.get(indexNumber).getStueckzahlStock();
            if(stueckzahlAlt >= stueckzahl) {
                int stueckzahlNeu = stueckzahlAlt - stueckzahl;
                arrayOfStocks.get(indexNumber).setStueckzahlStock(stueckzahlNeu);
            } else {System.out.println("Das Portfolio verfügt nicht oder in zu geringem Maße über die Aktie");}
        }}






    public String getNamePortfolio() {
        return namePortfolio;
    }

    public void setNamePortfolio(String namePortfolio) {
        this.namePortfolio = namePortfolio;
    }

    public  List<Stock> getArrayOfStocks() {
        return arrayOfStocks;
    }

    public void setArrayOfStocks(List<Stock> arrayOfStocks) {
        this.arrayOfStocks = arrayOfStocks;
    }

    @Override
    public String toString(){
        return this.namePortfolio;
    }




}

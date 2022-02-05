package com.apple.PortfolioManager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Stock implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    public String WKNStock;
    public String nameStock;
    public String artWertpapierStock;
    public int stueckzahlStock;



    public Stock(String nameStock,String WKNStock,String artWertpapierStock,int stueckzahlStock){
        this.nameStock = nameStock;
        this.WKNStock = WKNStock;
        this.artWertpapierStock = artWertpapierStock;
        this.stueckzahlStock = stueckzahlStock;
    }

    public Stock() {

    }


    //Getter and Setter

    public String getNamePortfolio() {
        return nameStock;
    }

    public void setNamePortfolio(String namePortfolio) {
        this.nameStock = namePortfolio;
    }

    public String getWKNPortfolio() {
        return WKNStock;
    }

    public void setWKNPortfolio(String WKNPortfolio) {
        this.WKNStock = WKNPortfolio;
    }

    public String getArtWertpapierPortfolio() {
        return artWertpapierStock;
    }

    public void setArtWertpapierPortfolio(String artWertpapierPortfolio) {
        this.artWertpapierStock = artWertpapierPortfolio;
    }

    public int getStueckzahlPortfolio() {
        return stueckzahlStock;
    }

    public void setStueckzahlPortfolio(int stueckzahlPortfolio) {
        this.stueckzahlStock = stueckzahlPortfolio;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    @Override
    public String toString(){
        return "name: " + this.nameStock + " WKN: "+ this.WKNStock + " art: " + this.artWertpapierStock + " zahl: " + this.stueckzahlStock ;
    }


}

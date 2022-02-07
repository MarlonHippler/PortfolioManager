package com.apple.PortfolioManager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Stock implements Serializable {

    /**
     * Model für Stock
     *
     * @author  Marlon Hippler
     */
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

    public String getWKNStock() {
        return WKNStock;
    }

    public void setWKNStock(String WKNStock) {
        this.WKNStock = WKNStock;
    }

    public String getNameStock() {
        return nameStock;
    }

    public void setNameStock(String nameStock) {
        this.nameStock = nameStock;
    }

    public String getArtWertpapierStock() {
        return artWertpapierStock;
    }

    public void setArtWertpapierStock(String artWertpapierStock) {
        this.artWertpapierStock = artWertpapierStock;
    }

    public int getStueckzahlStock() {
        return stueckzahlStock;
    }

    public void setStueckzahlStock(int stueckzahlStock) {
        this.stueckzahlStock = stueckzahlStock;
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

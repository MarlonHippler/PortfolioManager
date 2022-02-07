package com.apple.PortfolioManager.Request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StockRequestVerkauf {

    public String WKNStock;
    public int stueckzahlStock;
    public String portfolioName;

}
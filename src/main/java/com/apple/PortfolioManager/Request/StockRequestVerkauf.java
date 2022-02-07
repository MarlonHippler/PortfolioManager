package com.apple.PortfolioManager.Request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Request für den Verkauf von "Stock"
 *
 * @author  Marlon Hippler
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StockRequestVerkauf {

    public String WKNStock;
    public int stueckzahlStock;
    public String portfolioName;

}

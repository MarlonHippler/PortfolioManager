package com.apple.PortfolioManager.Request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Request für "Stock"
 *
 * @author  Marlon Hippler
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class StockRequest {

    public String WKNStock;
    public String nameStock;
    public String artWertpapierStock;
    public int stueckzahlStock;
    public String portfolioName;

}

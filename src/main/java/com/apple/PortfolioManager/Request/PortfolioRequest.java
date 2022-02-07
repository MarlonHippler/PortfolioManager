package com.apple.PortfolioManager.Request;
import com.apple.PortfolioManager.model.Stock;
import lombok.*;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Request für das Portfolio
 *
 * @author  Marlon Hippler
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class PortfolioRequest {


    public String portfolioName;




}

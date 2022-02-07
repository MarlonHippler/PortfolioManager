package com.apple.PortfolioManager.Request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Request für den Login
 *
 * @author  Marlon Hippler
 */
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class LogInRequest {

    public String username;
    public String password;

}

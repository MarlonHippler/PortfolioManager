package com.apple.PortfolioManager.Request;
import com.apple.PortfolioManager.model.Stock;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class PortfolioRequest {

    public String name;


}

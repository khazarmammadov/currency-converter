package az.cbar.currencyconverter.dto.response;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class CurrencyResponse {
    private String from;
    private String to;
    private BigDecimal amount;
}

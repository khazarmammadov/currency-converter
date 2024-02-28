package az.cbar.currencyconverter.service;

import az.cbar.currencyconverter.client.CurrencyClient;
import az.cbar.currencyconverter.dto.response.Currency;
import az.cbar.currencyconverter.dto.response.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient client;


    public BigDecimal convertCurrency(String from, String to, BigDecimal amount) {

        CurrencyResponse response = client.convert(from, to);

        Currency currency = new Currency();

        currency.setFrom(response.getFrom());
        currency.setTo(response.getTo());
        currency.setAmount(response.getAmount());

        return amount.multiply(currency.getAmount());
    }
}

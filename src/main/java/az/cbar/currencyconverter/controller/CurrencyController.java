package az.cbar.currencyconverter.controller;


import az.cbar.currencyconverter.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency/convert")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public BigDecimal currencyConverter(@RequestParam("from") String from,
                                        @RequestParam("to") String to,
                                        @RequestParam("amount") BigDecimal amount) {

        return currencyService.convertCurrency(from, to, amount);
    }
}

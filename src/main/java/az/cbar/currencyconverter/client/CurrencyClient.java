package az.cbar.currencyconverter.client;


import az.cbar.currencyconverter.dto.response.CurrencyResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CurrencyClient {

    private final RestTemplate restTemplate;

    public CurrencyClient(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    String currencyResource = "http://localhost:8080/currency/convert?from=%s&to=%s";
    public CurrencyResponse convert(String from, String to) {
        return restTemplate.getForEntity(String.format(currencyResource, from, to), CurrencyResponse.class).getBody();
    }
}
package com.kishor_gorantala.currency_conversion_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    public CurrencyConversionController(CurrencyExchangeProxy proxy){
        this.proxy=proxy;
    }

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion CalculatedCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        // HashMap<String,String> UriVariables = new HashMap<>();

      //  UriVariables.put("from",from);
       // UriVariables.put("to",to);

       // ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, UriVariables);

        //CurrencyConversion currencyconversion = currencyConversion.getBody();

        return new CurrencyConversion(currencyConversion.getId(),from,to,currencyConversion.getConversionMultiple(),quantity,currencyConversion.getEnvironment(),quantity.multiply(currencyConversion.getConversionMultiple()));
    }

}

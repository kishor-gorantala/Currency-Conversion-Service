package com.kishor_gorantala.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service",url = "http://localhost:8000/currency-exchange")
public interface CurrencyExchangeProxy {

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from,@PathVariable String to );

}

package com.starkend.currencyserviceloadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RibbonClient(name="currency-service")
@FeignClient(name="currency-service")
@RestController
public class CurrencyServiceProxy {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/currency-call")
    public String getCurrencies() {
        String returnString = this.restTemplate.getForObject(
                "http://currency-service/currencies", String.class);

        return returnString + " success";
    }

}

package com.starkend.currencyserviceloadbalancer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    private RestTemplate restTemplate;

    public CurrencyServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/currencies")
    @HystrixCommand(fallbackMethod = "currenciesFallback")
    public String getCurrencies() {
//        if (true) {
//            throw new RuntimeException("Testing Circuit Breaker");
//        }
        String returnString = this.restTemplate.getForObject(
                "http://currency-service/currencies", String.class);

        return returnString;
    }

    @GetMapping("/time")
    @HystrixCommand(fallbackMethod = "timeFallback")
    public String getTime() {
//        if (true) {
//            throw new RuntimeException("Testing ");
//        }
        String time = this.restTemplate.getForObject(
                "http://currency-service/time", String.class);

        return time;
    }

    public String currenciesFallback() {
        return "Currencies API unavailable.";
    }

    public String timeFallback() {
        return "Time is unavailable.";
    }
}

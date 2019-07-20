package com.starkend.currencyserviceloadbalancer;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="currency-service")
@RibbonClient(name ="currency-service")
public interface CurrencyServiceProxy {

    @GetMapping("/currencies")
    public String getCurrencies();

}

package com.starkend.currencyservice.controller;

import com.starkend.currencyservice.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CurrencyController {

    @Autowired
    Environment environment;

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/currencies")
    public String getCurrencies() {
        String port = environment.getProperty("local.server.port");
        return currencyService.getCurrencies() + " port: " + port;
    }

    @GetMapping("/time")
    public String getTime() {
        return LocalDateTime.now().toString();
    }
}

package com.starkend.currencyservice.controller;

import com.starkend.currencyservice.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CurrencyController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Environment environment;
    private CurrencyService currencyService;

    public CurrencyController(Environment environment, CurrencyService currencyService) {
        this.environment = environment;
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies")
    public String getCurrencies() {
        String port = environment.getProperty("local.server.port");
        logger.info("/currencies called, port: " + port);
        return currencyService.getCurrencies() + " port: " + port;
    }

    @GetMapping("/time")
    public String getTime() {
        return LocalDateTime.now().toString();
    }

}

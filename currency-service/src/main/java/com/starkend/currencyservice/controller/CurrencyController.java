package com.starkend.currencyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    Environment environment;

    @GetMapping("/currencies")
    public String getCurrencies() {
        String port = environment.getProperty("local.server.port");

        return "Here is a currency list on port: " + port;
    }

}

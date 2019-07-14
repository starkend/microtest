package com.starkend.currencyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @GetMapping("/currencies")
    public String getCurrencies() {
        return "Here is a currency list";
    }

}

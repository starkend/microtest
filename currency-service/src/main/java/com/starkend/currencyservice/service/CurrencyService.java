package com.starkend.currencyservice.service;

import java.util.List;

public interface CurrencyService {

    public List<String> getCurrencies();

    public String getTime();
}

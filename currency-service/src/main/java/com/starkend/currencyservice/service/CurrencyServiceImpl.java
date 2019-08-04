package com.starkend.currencyservice.service;

import com.starkend.currencyservice.dto.CurrenciesDto;
import com.starkend.currencyservice.dto.TimeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final String CURRENCIES_URL = "https://api.coinbase.com/v2/currencies";
    private static final String TIME_URL = "https://api.coinbase.com/v2/time";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<String> getCurrencies() {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        HttpEntity<CurrenciesDto> responseEntity = restTemplate.exchange(
                CURRENCIES_URL,
                HttpMethod.GET,
                entity,
                CurrenciesDto.class);

        CurrenciesDto dto = responseEntity.getBody();

        return dto.getCurrencyList();
    }

    @Override
    public String getTime() {
        HttpEntity<?> entity = new HttpEntity<>(buildHeaders());

        HttpEntity<TimeDto> responseEntity = restTemplate.exchange(
                TIME_URL,
                HttpMethod.GET,
                entity,
                TimeDto.class);

        TimeDto dto = responseEntity.getBody();

        return dto.getTime();
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}

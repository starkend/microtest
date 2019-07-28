package com.starkend.currencyservice;

import com.starkend.currencyservice.service.CurrencyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CurrencyServiceApplication.class)
public class CurrencyServiceTest {

    @Autowired
    CurrencyService currencyService;

    @Test
    public void whenGetCurrencies_thenReturnedPopulatedCurrenciesList() {
        List<String> currencyList = currencyService.getCurrencies();

        assertNotNull(currencyList);
        assertFalse(currencyList.isEmpty());
    }

}
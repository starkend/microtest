package com.starkend.currencyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrenciesDto {

    private List<CurrencyDto> data;

    public List<CurrencyDto> getData() {
        return data;
    }

    public void setData(List<CurrencyDto> data) {
        this.data = data;
    }

    public List<String> getCurrencyList() {
        List<String> currencyList = new ArrayList<>();

        getData().stream().forEach(currencyDto -> currencyList.add(currencyDto.getName()));

        return currencyList.stream().sorted().collect(Collectors.toList());
    }

    static class CurrencyDto {

        private String id;
        private String name;
        private String min_size;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMin_size() {
            return min_size;
        }

        public void setMin_size(String min_size) {
            this.min_size = min_size;
        }
    }


}
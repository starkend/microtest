package com.starkend.currencyservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeDto {

    private TimeData data;

    public TimeData getData() {
        return data;
    }

    public void setData(TimeData data) {
        this.data = data;
    }

    public String getTime() {
        return getData().getIso();
    }

    static class TimeData {
        private String iso;
        private String epoch;

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }

        public String getEpoch() {
            return epoch;
        }

        public void setEpoch(String epoch) {
            this.epoch = epoch;
        }
    }
}

package me.holzenkamp.estggg.data.currency.internal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CurrencyJson {

    private CurrencyValue eur_chf;

    public CurrencyValue getEur_chf() {
        return eur_chf;
    }

    public void setEur_chf(CurrencyValue eur_chf) {
        this.eur_chf = eur_chf;
    }
}
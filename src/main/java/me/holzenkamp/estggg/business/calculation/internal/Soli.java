package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.configuration.Configuration;

public class Soli {

    private final Income income;
    private final Configuration configuration;

    public Soli(Income income, Configuration configuration) {
        this.income = income;
        this.configuration = configuration;
    }


    public Double getSoliValue() {
        if (income.getValue() <= configuration.getSoli_Nullzone_bis()) {
            // Nullzone
            return 0.0;
        }
        // TODO: gleitzone beruecksichtigen
        // Regulaer
        return income.getValue() * configuration.getSoliAnteil();
    }
}

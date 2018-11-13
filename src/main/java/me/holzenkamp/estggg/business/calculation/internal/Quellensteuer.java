package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.configuration.Configuration;

public class Quellensteuer {

    private final Income income;
    private final Configuration configuration;

    public Quellensteuer(Income income, Configuration configuration) {
        this.income = income;
        this.configuration = configuration;
    }

    public Double getQuellensteuer() {
        return income.getValue() * configuration.getQuellensteuer_CH();
    }

}

package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration;

public class Quellensteuer {

    public static Double calculate(Double lohn, Configuration configuration) {
        return lohn * configuration.getQuellensteuer_CH();
    }

}

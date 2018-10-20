package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration;

public class Soli {

    public static Double calculate(Double eSt, Configuration configuration) {
        if (eSt <= configuration.getSoli_Nullzone_bis()) {
            // Nullzone
            return 0.0;
        }
        // TODO: gleitzone beruecksichtigen
        // Regulaer
        return eSt * configuration.getSoliAnteil();
    }
}

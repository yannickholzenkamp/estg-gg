package me.holzenkamp.estggg.calculation;

import me.holzenkamp.estggg.CalculationParameters;
import me.holzenkamp.estggg.CalculationResult;
import me.holzenkamp.estggg.configuration.Configuration;

public class Calculator {

    public CalculationResult calculate(CalculationParameters parameters, Configuration configuration) {

        Double wechselkurs = Currency.eur_to_chf();
        Double zVE = parameters.getBruttolohn_jahr_ch_chf();

        EStG32 eStG32 = new EStG32(zVE, configuration);
        eStG32.calculate();

        // Build result
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setVerwendeter_kurs_chf(wechselkurs);

        calculationResult.setEinkommensteuer_de_eur(eStG32.getESt());
        calculationResult.setEinkommensteuer_de_prozent(eStG32.getEStPercent());
        calculationResult.setSolidaritaetszuschlag_de_eur(eStG32.getSoli());

        Double summe_zahlungen_de = eStG32.getESt() + eStG32.getSoli();
        calculationResult.setVorauszahlungen_quartal_de_eur(summe_zahlungen_de/4);
        calculationResult.setVorauszahlungen_monat_de_eur(summe_zahlungen_de/13);

        return calculationResult;
    }

}

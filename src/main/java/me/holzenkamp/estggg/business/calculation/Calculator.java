package me.holzenkamp.estggg.business.calculation;

import me.holzenkamp.estggg.business.calculation.internal.EStG32a;
import me.holzenkamp.estggg.business.calculation.internal.Quellensteuer;
import me.holzenkamp.estggg.business.calculation.internal.Soli;
import me.holzenkamp.estggg.business.dto.CalculationParameters;
import me.holzenkamp.estggg.business.dto.Result;
import me.holzenkamp.estggg.business.configuration.Configuration;
import me.holzenkamp.estggg.data.currency.CurrencyService;
import me.holzenkamp.estggg.util.NumberUtil;

import java.io.IOException;

import static me.holzenkamp.estggg.util.NumberUtil.roundFinanzamt;

public class Calculator {

    public static Result calculate(CalculationParameters parameters, Configuration configuration) throws IOException {

        // Wechselkurs 1 EUR = x CHF laden (aktueller Kurs)
        Double eurToChf = parameters.getWechselkurs() == null ? CurrencyService.eurToChf() : parameters.getWechselkurs();

        // Gesamtes zu versteuerndes Einkommen ermitteln (EUR)
        Double zVETotal = getZVETotal(parameters, eurToChf);

        // Schweizer Steuerdaten berechnen (CHF)
        Double quellensteuer = Quellensteuer.calculate(parameters.getLohn(), configuration);

        // Dautesche Steuerdaten berechnen
        EStG32a eStG32A = new EStG32a(zVETotal, configuration);
        eStG32A.calculate();
        Double steuersatz = eStG32A.getEStPercent();
        Double eSt = getEst(parameters.getLohn(), eStG32A.getESt(), parameters.getProgressionsVorbehalt(), eStG32A.getEStPercent());
        Double eStAbzglQuellensteuer = eSt - (quellensteuer / eurToChf);

        // Soli berechnen
        Double soli = Soli.calculate(eSt, configuration);

        // Gesamtzahlen berechnen
        Double summeZahlungenDe = eSt + soli;
        Double vorausZahlungQ = summeZahlungenDe/4;
        Double vorausZahlungM = summeZahlungenDe/13;

        // Berechnungsresultate verpacken
        Result result = new Result();
        result.setWechselkurs(eurToChf);
        result.setQuellensteuer(NumberUtil.roundFinanzamtPositive(quellensteuer));
        result.seteSt(roundFinanzamt(eStAbzglQuellensteuer));
        result.setBelastungDe(steuersatz);
        result.setSoli(soli);
        result.setVorauszahlungQ(roundFinanzamt(vorausZahlungQ));
        result.setVorauszahlungM(roundFinanzamt(vorausZahlungM));

        return result;
    }

    private static Double getZVETotal(CalculationParameters parameters, Double wechselkurs) {
        if (parameters.getProgressionsVorbehalt() > 0) {
            // Mit Progressionsvorbehalt rechnen
            return parameters.getLohn() / wechselkurs + parameters.getProgressionsVorbehalt();
        } else if (parameters.getProgressionsVorbehalt() == 0) {
            // Ohne Progressionsvorbehalt rechnen
            return parameters.getLohn() / wechselkurs;
        }
        // Progressionsvorbehalt < 0. Das ist nicht erlaubt.
        throw new RuntimeException("Progressionsvorbehalt sollte nicht negativ sein.");
    }

    private static Double getEst(Double zVe, Double eSt, Double progVorb, Double steuerSatz) {
        if (progVorb > 0) {
            return (zVe - progVorb) * steuerSatz;
        }
        return eSt;
    }

}

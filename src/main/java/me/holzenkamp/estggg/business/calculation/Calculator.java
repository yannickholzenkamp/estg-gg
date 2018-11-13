package me.holzenkamp.estggg.business.calculation;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.calculation.internal.TaxReport;
import me.holzenkamp.estggg.business.calculation.internal.TaxReport;
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
        TaxReport taxReport = new TaxReport(new Income(parameters.getLohn(), eurToChf, parameters.getProgressionsVorbehalt()), configuration);

        // Schweizer Steuerdaten berechnen (CHF)
        Double quellensteuer = taxReport.getQuellensteuer().getQuellensteuer();

        // Dautesche Steuerdaten berechnen
        Double eSt = taxReport.getEst();
        Double eStAbzglQuellensteuer = eSt - (quellensteuer / eurToChf);

        // Soli berechnen
        Double soli = taxReport.getSoli();

        // Gesamtzahlen berechnen
        Double summeZahlungenDe = eSt + soli;
        Double vorausZahlungQ = summeZahlungenDe / 4;
        Double vorausZahlungM = summeZahlungenDe / 13;

        // Berechnungsresultate verpacken
        Result result = new Result();
        result.setWechselkurs(eurToChf);
        result.setQuellensteuer(NumberUtil.roundFinanzamtPositive(quellensteuer));
        result.seteSt(roundFinanzamt(eStAbzglQuellensteuer));
        result.setBelastungDe(taxReport.getTaxRate());
        result.setSoli(soli);
        result.setVorauszahlungQ(roundFinanzamt(vorausZahlungQ));
        result.setVorauszahlungM(roundFinanzamt(vorausZahlungM));

        return result;
    }


}

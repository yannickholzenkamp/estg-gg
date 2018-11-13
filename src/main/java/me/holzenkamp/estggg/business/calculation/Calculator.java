package me.holzenkamp.estggg.business.calculation;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.calculation.internal.TaxReport;
import me.holzenkamp.estggg.business.configuration.Configuration;
import me.holzenkamp.estggg.business.dto.CalculationParameters;
import me.holzenkamp.estggg.business.dto.Result;
import me.holzenkamp.estggg.data.currency.CurrencyService;
import me.holzenkamp.estggg.util.NumberUtil;

import java.io.IOException;

import static me.holzenkamp.estggg.util.NumberUtil.roundFinanzamt;

public class Calculator {

    public static Result calculate(CalculationParameters parameters, Configuration configuration) throws IOException {
        Double wechselkurs = parameters.getWechselkurs() == null ? CurrencyService.eurToChf() : parameters.getWechselkurs();
        TaxReport taxReport = new TaxReport(new Income(parameters.getLohn(), wechselkurs, parameters.getProgressionsVorbehalt()), configuration);

        // Berechnungsresultate verpacken
        Result result = new Result();
        result.setWechselkurs(wechselkurs);
        result.setQuellensteuer(NumberUtil.roundFinanzamtPositive(taxReport.getQuellensteuer().getQuellensteuer()));
        result.seteSt(roundFinanzamt(taxReport.getPaymentSumDe()));
        result.setBelastungDe(taxReport.getTaxRate());
        result.setSoli(taxReport.getSoli());
        result.setVorauszahlungQ(roundFinanzamt(taxReport.getPaymentSumDe() / 4));
        result.setVorauszahlungM(roundFinanzamt(taxReport.getPaymentSumDe() / 13));

        return result;
    }


}

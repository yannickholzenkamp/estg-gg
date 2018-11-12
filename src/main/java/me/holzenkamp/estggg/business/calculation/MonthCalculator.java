package me.holzenkamp.estggg.business.calculation;

import me.holzenkamp.estggg.business.dto.MonthResult;
import me.holzenkamp.estggg.data.currency.CurrencyService;

import java.io.IOException;

public class MonthCalculator {

    public static MonthResult calculate(Double lohn, Double progVorb, Double abzgChf) throws IOException {

        Double wechselkurs = CurrencyService.eurToChf();

        Double lohnInEuro = lohn / wechselkurs;
        Double zVE = progVorb > 0 ? lohnInEuro + progVorb : lohnInEuro;

        return null;
    }

}

package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration;

public class EStG32a {

    private Configuration configuration;

    private Double taxableProfit;
    private Double x;
    private Double y;
    private Double z;
    private Double incomeTax;
    private Double incomeTaxPercentage;

    public EStG32a(Double taxableProfit, Configuration configuration) {
        this.configuration = configuration;
        this.taxableProfit = taxableProfit;
        calcBaseValues();
        calculate();
    }

    private void calcBaseValues() {
        // Die Größe "x" ist das auf einen vollen Euro-Betrag abgerundete zu versteuernde Einkommen.
        x = Math.floor(taxableProfit);

        // Die Größe "y" ist ein Zehntausendstel des den Grundfreibetrag übersteigenden Teils des auf einen vollen Euro-Betrag abgerundeten zu versteuernden Einkommens
        if (isYLevel()) {
            y = getZehntausendstel(x - configuration.getGrundfreibetrag_DE());
        }

        //Die Größe "z" ist ein Zehntausendstel des 13.996 Euro übersteigenden Teils des auf einen vollen Euro-Betrag abgerundeten zu versteuernden Einkommens
        if (isZLevel()) {
            z = getZehntausendstel(x - configuration.getZLevel_DE());
        }
    }

    public void calculate() {
        // TODO do not hardcode these values
        if (isAmountBetween(0.0, configuration.getGrundfreibetrag_DE(), taxableProfit)) {
            incomeTax = calcFirstStage();
        } else if (isAmountBetween(9001.0, 13996.0, taxableProfit)) {
            incomeTax = calcSecondStage();
        } else if (isAmountBetween(13397.0, 54949.0, taxableProfit)) {
            incomeTax = calcThirdStage();
        } else if (isAmountBetween(54950.0, 260532.0, taxableProfit)) {
            incomeTax = calcFourthStage();
        } else {
            incomeTax = calcFifthStage();
        }
        incomeTax = Math.floor(incomeTax);
        incomeTaxPercentage = (incomeTax / taxableProfit);
    }

    private Double calcFirstStage() {
        // bis 9.000 Euro (Grundfreibetrag): 0
        return 0.0;
    }

    private Double calcSecondStage() {
        // von 9.001 Euro bis 13.996 Euro: (997,8 · y + 1 400) · y;
        if (y != null) {
            return (997.8 * y + 1400) * y;
        }
        return 0.0;
    }

    private Double calcThirdStage() {
        // von 13.997 Euro bis 54.949 Euro: (220,13 · z + 2 397) · z + 948,49;
        if (z != null) {
            return (220.13 * z + 2397) * z + 948.49;
        }
        return 0.0;
    }

    private Double calcFourthStage() {
        // von 54.950 Euro bis 260.532 Euro: 0,42 · x - 8.621,75;
        return 0.42 * x - 8621.75;
    }

    private Double calcFifthStage() {
        //von 260.533 Euro an: 0,45 · x - 16.437,7.
        return 0.45 * x - 16437.7;
    }

    private boolean isAmountBetween(Double from, Double to, Double of) {
        return Math.floor(of) <= to && Math.floor(of) >= from;
    }

    private Double getZehntausendstel(Double of) {
        return of / 10000.0;
    }

    private boolean isYLevel() {
        return taxableProfit > configuration.getGrundfreibetrag_DE();
    }

    private boolean isZLevel() {
        return taxableProfit > configuration.getZLevel_DE();
    }

    public Double getIncomeTax() {
        return incomeTax;
    }

    public Double getIncomeTaxPercentage() {
        return incomeTaxPercentage;
    }

}

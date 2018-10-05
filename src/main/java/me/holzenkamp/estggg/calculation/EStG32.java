package me.holzenkamp.estggg.calculation;

import me.holzenkamp.estggg.configuration.Configuration;

public class EStG32 {

    private Configuration configuration;

    private Double zVE;
    private Double x;
    private Double y;
    private Double z;
    private Double ESt;
    private Double EStPercent;
    private Double Soli;

    public EStG32(Double zVE, Configuration configuration) {
        this.configuration = configuration;
        this.zVE = zVE;
        calcBaseValues();
    }

    private void calcBaseValues() {
        // Die Größe "x" ist das auf einen vollen Euro-Betrag abgerundete zu versteuernde Einkommen.
        x = Math.floor(zVE);

        // Die Größe "y" ist ein Zehntausendstel des den Grundfreibetrag übersteigenden Teils des auf einen vollen Euro-Betrag abgerundeten zu versteuernden Einkommens
        if (isYLevel()) {
            y = getZehntausendstel(Math.floor(zVE) - configuration.getGrundfreibetrag_DE());
        }

        //Die Größe "z" ist ein Zehntausendstel des 13.996 Euro übersteigenden Teils des auf einen vollen Euro-Betrag abgerundeten zu versteuernden Einkommens
        if (isZLevel()) {
            z = getZehntausendstel(Math.floor(zVE) - configuration.getZLevel_DE());
        }
    }

    public void calculate() {
        if (isAmountBetween(0.0, configuration.getGrundfreibetrag_DE(), zVE)) {
            ESt = calcFirstStage();
        } else if (isAmountBetween(9001.0, 13996.0, zVE)) {
            ESt = calcSecondStage();
        } else if (isAmountBetween(13397.0, 54949.0, zVE)) {
            ESt = calcThirdStage();
        } else if (isAmountBetween(54950.0, 260532.0, zVE)) {
            ESt = calcFourthStage();
        } else {
            ESt = calcFifthStage();
        }
        ESt = Math.floor(ESt);
        EStPercent = (ESt / zVE) * 100.0;
        Soli = Math.floor(ESt * configuration.getSoliAnteil());
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
        return zVE > configuration.getZLevel_DE();
    }

    private boolean isZLevel() {
        return zVE > configuration.getZLevel_DE();
    }

    public Double getESt() {
        return ESt;
    }

    public Double getEStPercent() {
        return EStPercent;
    }

    public Double getSoli() {
        return Soli;
    }

}

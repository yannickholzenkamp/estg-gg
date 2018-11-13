package me.holzenkamp.estggg.business;

public class Income {

    private final Double value;
    private final Double wechselkurs;
    private final Double progressionsVorbehalt;

    public Double getValue() {
        return value;
    }

    public Double getProgressionsVorbehalt() {
        return progressionsVorbehalt;
    }

    public Double getInEuro() {
        return value / wechselkurs;
    }

    public Double getWechselkurs() {
        return wechselkurs;
    }

    public Income(Double value, Double wechselkurs) {
        this(value, wechselkurs, (double) 0);
    }

    public Income(Double value, Double wechselkurs, Double progressionsVorbehalt) {
        this.value = value;
        this.wechselkurs = wechselkurs;
        this.progressionsVorbehalt = progressionsVorbehalt;
    }

    public Double getZVETotal() {
        if (progressionsVorbehalt < 0) {
            throw new RuntimeException("Progressionsvorbehalt sollte nicht negativ sein.");
        } else if (progressionsVorbehalt > 0) {
            return value / wechselkurs + progressionsVorbehalt;
        } else {
            return value / wechselkurs;
        }
    }
}

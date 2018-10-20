package me.holzenkamp.estggg.business.dto;

import java.util.Objects;

public class CalculationParameters {

    // Required
    // Lohn (Jahr, Brutto, CHF)
    private Double lohn;

    // Optional
    // Progressionsvorbehalt DE (EUR/Jahr)
    private Double progressionsVorbehalt = 0.0;

    // Optional
    // CHF/EUR Wechselkurs: 1 EUR = x CHF
    private Double wechselkurs;

    public Double getLohn() {
        return lohn;
    }

    public void setLohn(Double lohn) {
        this.lohn = lohn;
    }

    public Double getProgressionsVorbehalt() {
        return progressionsVorbehalt;
    }

    public void setProgressionsVorbehalt(Double progressionsVorbehalt) {
        this.progressionsVorbehalt = progressionsVorbehalt;
    }

    public Double getWechselkurs() {
        return wechselkurs;
    }

    public void setWechselkurs(Double wechselkurs) {
        this.wechselkurs = wechselkurs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationParameters that = (CalculationParameters) o;
        return Objects.equals(lohn, that.lohn) &&
                Objects.equals(progressionsVorbehalt, that.progressionsVorbehalt) &&
                Objects.equals(wechselkurs, that.wechselkurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lohn, progressionsVorbehalt, wechselkurs);
    }

    @Override
    public String toString() {
        return "CalculationParameters{" +
                "lohn=" + lohn +
                ", progressionsVorbehalt=" + progressionsVorbehalt +
                ", wechselkurs=" + wechselkurs +
                '}';
    }
}

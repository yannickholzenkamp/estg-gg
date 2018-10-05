package me.holzenkamp.estggg;

public class CalculationParameters {

    // Required
    private Double bruttolohn_jahr_ch_chf;

    // Optional
    private Double progressionsvorbehalt_de_eur = 0.0;

    // Optional
    private Double steuerabzuege_de_eur = 0.0;

    // Optional
    private Double kapitalertraege_ueber_pauschbetrag_de_eur = 0.0;

    // Optional
    private CalculationParametersExtended extended;

    public Double getBruttolohn_jahr_ch_chf() {
        return bruttolohn_jahr_ch_chf;
    }

    public void setBruttolohn_jahr_ch_chf(Double bruttolohn_jahr_ch_chf) {
        this.bruttolohn_jahr_ch_chf = bruttolohn_jahr_ch_chf;
    }

    public Double getProgressionsvorbehalt_de_eur() {
        return progressionsvorbehalt_de_eur;
    }

    public void setProgressionsvorbehalt_de_eur(Double progressionsvorbehalt_de_eur) {
        this.progressionsvorbehalt_de_eur = progressionsvorbehalt_de_eur;
    }

    public Double getSteuerabzuege_de_eur() {
        return steuerabzuege_de_eur;
    }

    public void setSteuerabzuege_de_eur(Double steuerabzuege_de_eur) {
        this.steuerabzuege_de_eur = steuerabzuege_de_eur;
    }

    public Double getKapitalertraege_ueber_pauschbetrag_de_eur() {
        return kapitalertraege_ueber_pauschbetrag_de_eur;
    }

    public void setKapitalertraege_ueber_pauschbetrag_de_eur(Double kapitalertraege_ueber_pauschbetrag_de_eur) {
        this.kapitalertraege_ueber_pauschbetrag_de_eur = kapitalertraege_ueber_pauschbetrag_de_eur;
    }

    public CalculationParametersExtended getExtended() {
        return extended;
    }

    public void setExtended(CalculationParametersExtended extended) {
        this.extended = extended;
    }
}

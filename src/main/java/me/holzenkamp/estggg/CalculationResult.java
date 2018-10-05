package me.holzenkamp.estggg;

public class CalculationResult {

    Double verwendeter_kurs_chf;

    Double quellensteuer_ch_chf;
    Double summe_sozialabzuege_ch_chf;
    Double krankenversicherung_ch_chf;

    Double einkommensteuer_de_eur;
    Double einkommensteuer_de_prozent;

    Double solidaritaetszuschlag_de_eur;

    Double vorauszahlungen_quartal_de_eur;
    Double vorauszahlungen_monat_de_eur;

    Double summe_abzuege_prozent;
    Double netto_eur;

    public Double getVerwendeter_kurs_chf() {
        return verwendeter_kurs_chf;
    }

    public void setVerwendeter_kurs_chf(Double verwendeter_kurs_chf) {
        this.verwendeter_kurs_chf = verwendeter_kurs_chf;
    }

    public Double getQuellensteuer_ch_chf() {
        return quellensteuer_ch_chf;
    }

    public void setQuellensteuer_ch_chf(Double quellensteuer_ch_chf) {
        this.quellensteuer_ch_chf = quellensteuer_ch_chf;
    }

    public Double getSumme_sozialabzuege_ch_chf() {
        return summe_sozialabzuege_ch_chf;
    }

    public void setSumme_sozialabzuege_ch_chf(Double summe_sozialabzuege_ch_chf) {
        this.summe_sozialabzuege_ch_chf = summe_sozialabzuege_ch_chf;
    }

    public Double getKrankenversicherung_ch_chf() {
        return krankenversicherung_ch_chf;
    }

    public void setKrankenversicherung_ch_chf(Double krankenversicherung_ch_chf) {
        this.krankenversicherung_ch_chf = krankenversicherung_ch_chf;
    }

    public Double getEinkommensteuer_de_eur() {
        return einkommensteuer_de_eur;
    }

    public void setEinkommensteuer_de_eur(Double einkommensteuer_de_eur) {
        this.einkommensteuer_de_eur = einkommensteuer_de_eur;
    }

    public Double getEinkommensteuer_de_prozent() {
        return einkommensteuer_de_prozent;
    }

    public void setEinkommensteuer_de_prozent(Double einkommensteuer_de_prozent) {
        this.einkommensteuer_de_prozent = einkommensteuer_de_prozent;
    }

    public Double getSolidaritaetszuschlag_de_eur() {
        return solidaritaetszuschlag_de_eur;
    }

    public void setSolidaritaetszuschlag_de_eur(Double solidaritaetszuschlag_de_eur) {
        this.solidaritaetszuschlag_de_eur = solidaritaetszuschlag_de_eur;
    }

    public Double getVorauszahlungen_quartal_de_eur() {
        return vorauszahlungen_quartal_de_eur;
    }

    public void setVorauszahlungen_quartal_de_eur(Double vorauszahlungen_quartal_de_eur) {
        this.vorauszahlungen_quartal_de_eur = vorauszahlungen_quartal_de_eur;
    }

    public Double getVorauszahlungen_monat_de_eur() {
        return vorauszahlungen_monat_de_eur;
    }

    public void setVorauszahlungen_monat_de_eur(Double vorauszahlungen_monat_de_eur) {
        this.vorauszahlungen_monat_de_eur = vorauszahlungen_monat_de_eur;
    }

    public Double getSumme_abzuege_prozent() {
        return summe_abzuege_prozent;
    }

    public void setSumme_abzuege_prozent(Double summe_abzuege_prozent) {
        this.summe_abzuege_prozent = summe_abzuege_prozent;
    }

    public Double getNetto_eur() {
        return netto_eur;
    }

    public void setNetto_eur(Double netto_eur) {
        this.netto_eur = netto_eur;
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "verwendeter_kurs_chf=" + verwendeter_kurs_chf +
                ", quellensteuer_ch_chf=" + quellensteuer_ch_chf +
                ", summe_sozialabzuege_ch_chf=" + summe_sozialabzuege_ch_chf +
                ", krankenversicherung_ch_chf=" + krankenversicherung_ch_chf +
                ", einkommensteuer_de_eur=" + einkommensteuer_de_eur +
                ", einkommensteuer_de_prozent=" + einkommensteuer_de_prozent +
                ", solidaritaetszuschlag_de_eur=" + solidaritaetszuschlag_de_eur +
                ", vorauszahlungen_quartal_de_eur=" + vorauszahlungen_quartal_de_eur +
                ", vorauszahlungen_monat_de_eur=" + vorauszahlungen_monat_de_eur +
                ", summe_abzuege_prozent=" + summe_abzuege_prozent +
                ", netto_eur=" + netto_eur +
                '}';
    }
}

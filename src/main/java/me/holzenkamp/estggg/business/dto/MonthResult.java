package me.holzenkamp.estggg.business.dto;

import java.util.Objects;

public class MonthResult {

    // Verwendeter Wechselkurs: 1 EUR = x CHF
    Double wechselkurs;

    // Quellensteuer in dem Monat (CHF)
    Double ueberweisung;

    // Einkommensteuer DE abzgl. bezahlte Quellensteuer (EUR)
    Double eSt;
    
    // Solidaritaetszuschlag in dem Monat (EUR)
    Double soli;

    // Steuervorauszahlungen in dem Monat (EUR)
    Double vorauszahlung;

    // Ungefähres Nettoeinkommen für den Monat (EUR)
    Double netto;

    public Double getWechselkurs() {
        return wechselkurs;
    }

    public void setWechselkurs(Double wechselkurs) {
        this.wechselkurs = wechselkurs;
    }

    public Double geteSt() {
        return eSt;
    }

    public void seteSt(Double eSt) {
        this.eSt = eSt;
    }

    public Double getSoli() {
        return soli;
    }

    public void setSoli(Double soli) {
        this.soli = soli;
    }

    public Double getUeberweisung() {
        return ueberweisung;
    }

    public void setUeberweisung(Double ueberweisung) {
        this.ueberweisung = ueberweisung;
    }

    public Double getVorauszahlung() {
        return vorauszahlung;
    }

    public void setVorauszahlung(Double vorauszahlung) {
        this.vorauszahlung = vorauszahlung;
    }

    public Double getNetto() {
        return netto;
    }

    public void setNetto(Double netto) {
        this.netto = netto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonthResult that = (MonthResult) o;
        return Objects.equals(wechselkurs, that.wechselkurs) &&
                Objects.equals(ueberweisung, that.ueberweisung) &&
                Objects.equals(eSt, that.eSt) &&
                Objects.equals(soli, that.soli) &&
                Objects.equals(vorauszahlung, that.vorauszahlung) &&
                Objects.equals(netto, that.netto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wechselkurs, ueberweisung, eSt, soli, vorauszahlung, netto);
    }

    @Override
    public String toString() {
        return "MonthResult{" +
                "wechselkurs=" + wechselkurs +
                ", ueberweisung=" + ueberweisung +
                ", eSt=" + eSt +
                ", soli=" + soli +
                ", vorauszahlung=" + vorauszahlung +
                ", netto=" + netto +
                '}';
    }
}

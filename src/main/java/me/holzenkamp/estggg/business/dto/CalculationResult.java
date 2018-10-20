package me.holzenkamp.estggg.business.dto;

public class CalculationResult {

    // TODO fix according to swagger definition

    // Verwendeter Wechselkurs: 1 EUR = x CHF
    Double wechselkurs;

    // Quellensteuer in CHF/Jahr
    Double quellensteuer;

    // Einkommensteuer DE abzgl. bezahlte Quellensteuer in EUR/Jahr
    Double eSt;
    
    // Durchschnittssteuersatz (ohne Soli) in EUR/Jahr
    Double belastungDe;

    // Solidaritaetszuschlag in EUR/Jahr
    Double soli;

    // Steuervorauszahlungen (nur DE) in EUR/Quartal
    Double vorauszahlungQ;

    // Steuervorauszahlungen (nur DE) in EUR/Monat (gerechnet mit 13 Monaten)
    Double vorauszahlungM;

    public Double getWechselkurs() {
        return wechselkurs;
    }

    public void setWechselkurs(Double wechselkurs) {
        this.wechselkurs = wechselkurs;
    }

    public Double getQuellensteuer() {
        return quellensteuer;
    }

    public void setQuellensteuer(Double quellensteuer) {
        this.quellensteuer = quellensteuer;
    }

    public Double geteSt() {
        return eSt;
    }

    public void seteSt(Double eSt) {
        this.eSt = eSt;
    }

    public Double getBelastungDe() {
        return belastungDe;
    }

    public void setBelastungDe(Double belastungDe) {
        this.belastungDe = belastungDe;
    }

    public Double getSoli() {
        return soli;
    }

    public void setSoli(Double soli) {
        this.soli = soli;
    }

    public Double getVorauszahlungQ() {
        return vorauszahlungQ;
    }

    public void setVorauszahlungQ(Double vorauszahlungQ) {
        this.vorauszahlungQ = vorauszahlungQ;
    }

    public Double getVorauszahlungM() {
        return vorauszahlungM;
    }

    public void setVorauszahlungM(Double vorauszahlungM) {
        this.vorauszahlungM = vorauszahlungM;
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "wechselkurs=" + wechselkurs +
                ", quellensteuer=" + quellensteuer +
                ", eSt=" + eSt +
                ", belastungDe=" + belastungDe +
                ", soli=" + soli +
                ", vorauszahlungQ=" + vorauszahlungQ +
                ", vorauszahlungM=" + vorauszahlungM +
                '}';
    }
}

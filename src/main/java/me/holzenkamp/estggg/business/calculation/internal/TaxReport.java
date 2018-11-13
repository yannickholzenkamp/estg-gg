package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.configuration.Configuration;

public class TaxReport {

    private final Income income;
    private final Configuration configuration;
    private final Soli soli;
    private final Quellensteuer quellensteuer;
    private final EStG32a eStG32a;

    public TaxReport(Income income, Configuration configuration) {
        this.income = income;
        this.configuration = configuration;
        this.soli = new Soli(income, configuration);
        this.quellensteuer = new Quellensteuer(income, configuration);
        this.eStG32a = new EStG32a(income.getZVETotal(), configuration);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Double getSoli() {
        return soli.getSoliValue();
    }

    public Quellensteuer getQuellensteuer() {
        return quellensteuer;
    }

    public Double getEst() {
        if (income.getProgressionsVorbehalt() > 0) {
            return (income.getInEuro() - income.getProgressionsVorbehalt()) * eStG32a.getIncomeTaxPercentage();
        }
        return eStG32a.getIncomeTax();
    }

    public Double getTaxRate() {
        return eStG32a.getIncomeTaxPercentage();
    }

    public Double getTaxSum() {
        return getEst() + getSoli();
    }

    public Double getPaymentSumDe() {
        return getEst() - (getQuellensteuer().getQuellensteuer() / income.getWechselkurs());
    }

}

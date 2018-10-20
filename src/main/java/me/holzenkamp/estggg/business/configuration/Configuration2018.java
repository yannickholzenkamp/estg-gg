package me.holzenkamp.estggg.business.configuration;

public class Configuration2018 implements Configuration {

    public Double getGrundfreibetrag_DE() {
        return 9000.0;
    }

    public Double getZLevel_DE() {
        return 13996.0;
    }

    public Double getSoliAnteil() {
        return 0.055;
    }

    public Double getQuellensteuer_CH() {
        return 0.045;
    }

    public Double getSoli_Nullzone_bis() {
        return 972.0;
    }

    public Double getSoli_Gleitzone_bis() {
        return 1340.0;
    }

}

package me.holzenkamp.estggg.configuration;

public class Configuration_2018 implements Configuration {

    @Override
    public Double getGrundfreibetrag_DE() {
        return 9000.0;
    }

    @Override
    public Double getZLevel_DE() {
        return 13996.0;
    }

    @Override
    public Double getSoliAnteil() {
        return 0.055;
    }

    @Override
    public Double getQuellensteuer_CH() {
        return 0.045;
    }

}

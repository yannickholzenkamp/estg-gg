package me.holzenkamp.estggg.util;

public class NumberUtil {

    // TODO necessary?

    public static Double formatNum(Double num) {
        return (double) Math.round(num * 100) / 100;
    }

    public static Double formatNumPositive(Double num) {
        if (num < 0.0) return 0.0;
        return formatNum(num);
    }

    public static Double formatDeFin(Double num) {
        return Math.floor(num * 100) / 100;
    }

}

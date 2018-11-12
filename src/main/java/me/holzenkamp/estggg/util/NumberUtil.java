package me.holzenkamp.estggg.util;

public class NumberUtil {

    public static Double roundFinanzamt(Double num) {
        return (double) Math.round(num * 100) / 100;
    }

    public static Double roundFinanzamtPositive(Double num) {
        if (num < 0.0) return 0.0;
        return roundFinanzamt(num);
    }

}

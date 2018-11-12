package me.holzenkamp.estggg.util;

public class ValidationUtil {

    public static void validateMandatory(Double value, String paramName) {
        if (value == null) {
            throw new RuntimeException("Der Parameter '" + paramName + "' muss gesetzt sein.");
        }
    }

    public static void validateNotNegative(Double value, String paramName) {
        if (value != null && value < 0.0) {
            throw new RuntimeException("Der Parameter '" + paramName + "' darf nicht negativ sein.");
        }
    }

}

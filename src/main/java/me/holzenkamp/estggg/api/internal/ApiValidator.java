package me.holzenkamp.estggg.api.internal;

public class ApiValidator {

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

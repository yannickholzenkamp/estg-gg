package me.holzenkamp.estggg;

import me.holzenkamp.estggg.calculation.Calculator;
import me.holzenkamp.estggg.configuration.Configuration_2018;

public class App {

    public static void main(String[] args) {

        CalculationParameters calculationParameters = new CalculationParameters();
        calculationParameters.setBruttolohn_jahr_ch_chf(100000.0);

        Calculator calculator = new Calculator();
        CalculationResult calculation = calculator.calculate(calculationParameters, new Configuration_2018());

        System.out.println(calculation);
    }

}

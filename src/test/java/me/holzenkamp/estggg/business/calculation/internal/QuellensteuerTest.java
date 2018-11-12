package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration2018;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuellensteuerTest {

    @Test
    void calculate_2018() {
        Double result = Quellensteuer.calculate(50000d, new Configuration2018());

        assertEquals(2250.0, result, 0.01);
    }

    @Test
    void calculate_2018_small() {
        Double result = Quellensteuer.calculate(3000d, new Configuration2018());

        assertEquals(135.0, result, 0.01);
    }

    @Test
    void calculate_2018_large() {
        Double result = Quellensteuer.calculate(250000d, new Configuration2018());

        assertEquals(11250.0, result, 0.01);
    }
}
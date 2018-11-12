package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration2018;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoliTest {

    @Test
    void calculate_2018() {
        Double result = Soli.calculate(50000d, new Configuration2018());

        assertEquals(2750.0, result, 0.01);
    }

    @Test
    void calculate_2018_small() {
        Double result = Soli.calculate(3000d, new Configuration2018());

        assertEquals(165.0, result, 0.01);
    }

    @Test
    void calculate_2018_large() {
        Double result = Soli.calculate(250000d, new Configuration2018());

        assertEquals(13750.0, result, 0.01);
    }
}
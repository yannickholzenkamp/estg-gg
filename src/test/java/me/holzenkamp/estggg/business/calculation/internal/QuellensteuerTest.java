package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.configuration.Configuration2018;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuellensteuerTest {

    @Test
    void calculate_2018() {
        Double result = new Quellensteuer(new Income(50000d, null), new Configuration2018()).getQuellensteuer();

        assertEquals(2250.0, result, 0.01);
    }

    @Test
    void calculate_2018_small() {
        Double result = new Quellensteuer(new Income(3000d, null), new Configuration2018()).getQuellensteuer();

        assertEquals(135.0, result, 0.01);
    }

    @Test
    void calculate_2018_large() {
        Double result = new Quellensteuer(new Income(250000d, null), new Configuration2018()).getQuellensteuer();

        assertEquals(11250.0, result, 0.01);
    }
}
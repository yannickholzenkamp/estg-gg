package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.Income;
import me.holzenkamp.estggg.business.configuration.Configuration2018;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoliTest {

    @Test
    void calculate_2018() {
        Double result = new Soli(new Income(50000d, null), new Configuration2018()).getSoliValue();

        assertEquals(2750.0, result, 0.01);
    }

    @Test
    void calculate_2018_small() {
        Double result = new Soli(new Income(3000d, null), new Configuration2018()).getSoliValue();

        assertEquals(165.0, result, 0.01);
    }

    @Test
    void calculate_2018_large() {
        Double result = new Soli(new Income(250000d, null), new Configuration2018()).getSoliValue();

        assertEquals(13750.0, result, 0.01);
    }

    @Test
    void calculate_2018_underLimit() {
        Double result = new Soli(new Income(650d, null), new Configuration2018()).getSoliValue();

        assertEquals(0.0, result, 0.01);
    }
}
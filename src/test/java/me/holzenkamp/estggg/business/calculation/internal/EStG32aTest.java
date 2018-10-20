package me.holzenkamp.estggg.business.calculation.internal;

import me.holzenkamp.estggg.business.configuration.Configuration2018;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EStG32aTest {

    @Test
    public void test() {
        assertEquals(0.0, calc(9000.0));
        assertEquals(149.0, calc(10000.0));
        assertEquals(2467.0, calc(20000.0));
        assertEquals(5348.0, calc(30000.0));
        assertEquals(8670.0, calc(40000.0));
        assertEquals(12432.0, calc(50000.0));
        assertEquals(16578.0, calc(60000.0));
        assertEquals(20778.0, calc(70000.0));
        assertEquals(24978.0, calc(80000.0));
        assertEquals(29178.0, calc(90000.0));
        assertEquals(33378.0, calc(100000.0));
        assertEquals(75378.0, calc(200000.0));
    }

    private double calc(double income) {
        EStG32a eStG32a = new EStG32a(income, new Configuration2018());
        eStG32a.calculate();
        return eStG32a.getESt();
    }

}

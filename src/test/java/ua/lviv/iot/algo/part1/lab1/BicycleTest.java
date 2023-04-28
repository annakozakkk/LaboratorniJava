package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BicycleTest {
    @Test
    public void testGetMaxDistance() {
        var bicycle = new Bicycle("Colnago", 60, 45);
        assertEquals(2147483647, bicycle.getMaxDistance());
    }

    @Test
    public void testHeader() {
        var bicycle = new Bicycle("Colnago", 23.0, 12.0);
        assertEquals("brand,maxSpeed,currentSpeed", bicycle.getHeaders());
    }

    @Test
    public void testToCSV() {
        var bicycle = new Bicycle("Colnago", 23.0, 12.0);
        assertEquals("Colnago,23.0,12.0", bicycle.toCSV());
    }
}

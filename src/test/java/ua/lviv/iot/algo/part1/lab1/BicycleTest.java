package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BicycleTest {
    @Test
    public void testGetMaxDistance(){
        var bicycle=new Bicycle("Colnago", 60, 45);
        assertEquals(2147483647,bicycle.getMaxDistance());
    }
}
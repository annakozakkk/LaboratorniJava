package ua.lviv.iot.algo.part1.lab1;

import lombok.Builder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElectricScooterTest {
    @Test
    public void testGetMaxDistance() {
        var electricScooter = new ElectricScooter("Bolt", 30, 15, 2, 15);

        assertEquals(30.0, electricScooter.getMaxDistance());
    }
    @Test
    public void testGetMaxDistanceIfTimeToDriveOnBatteryChargeIsZero(){
        var electricScooter=new ElectricScooter("Bolt", 30, 15, 0, 15);

        assertEquals(0.0,electricScooter.getMaxDistance());

    }
    @Test
    public void testGetMaxDistanceIfAverageSpeedIsZero(){
        var electricScooter=new ElectricScooter("Bolt", 30, 15, 2, 0);

        assertEquals(0.0,electricScooter.getMaxDistance());

    }
    }

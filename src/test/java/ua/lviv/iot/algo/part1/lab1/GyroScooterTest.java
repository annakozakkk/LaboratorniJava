package ua.lviv.iot.algo.part1.lab1;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GyroScooterTest {
    @Test
    public void testGetMaxDistance() {
        var gyroScooter = new GyroScooter("Smart Balance", 30, 10, 20, 36, 0.2);
        assertEquals(3600, gyroScooter.getMaxDistance());
    }

    @Test
    public void testGetMaxDistanceUsingDefaultConstructor() {
        var gyroScooter = new GyroScooter();
        double maxDistance = gyroScooter.getMaxDistance();
        assertTrue(Double.isNaN(maxDistance));
    }

    @Test
    public void testGetMaxDistanceIfCapacityOfBatteryIsZero() {
        var gyroScooter = new GyroScooter("Smart Balance", 30, 10, 0, 36, 0.2);
        assertEquals(0.0, gyroScooter.getMaxDistance());
    }

    @Test
    public void testGetMaxDistanceIfBatteryVoltageIsZero() {
        var gyroScooter = new GyroScooter("Smart Balance", 30, 10, 20, 0, 0.2);
        assertEquals(0.0, gyroScooter.getMaxDistance());
    }

    @Test
    public void testGetMaxDistanceWhenEnergyConsumptionPer1kmIsZero() {
        GyroScooter gyroScooter = new GyroScooter("SmartBalance", 20.0, 10.0, 100.0, 12.0, 0.0);
        double expectedMaxDistance = Double.POSITIVE_INFINITY;
        double actualMaxDistance = gyroScooter.getMaxDistance();
        assertEquals(expectedMaxDistance, actualMaxDistance);
    }
    @Test
    public void testHeader(){
        var gyroScooter = new GyroScooter("Smart Balance", 30, 10, 20, 36, 0.2);
        assertEquals("brand,maxSpeed,currentSpeed,capacityOfBattery,batteryVoltage,energyConsumptionPer1km",gyroScooter.getHeaders());
    }
    @Test
    public void testToCSV(){
        var gyroScooter=new GyroScooter("Smart Balance", 30, 10, 20, 36, 0.2);
        assertEquals("Smart Balance,30.0,10.0,20.0,36.0,0.2",gyroScooter.toCSV());
    }
}
package ua.lviv.iot.algo.part1.ProjectorLab;

import org.junit.Test;
import ua.lviv.iot.algo.part1.projector.model.ElectricBicycle;

import static org.junit.jupiter.api.Assertions.*;

public class ElectricBicycleTest {
    @Test
    public void testMaxDistance() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        assertEquals(175, electricBicycle.getMaxDistance());
    }

    @Test
    public void testHeader() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        assertEquals("brand,maxSpeed,currentSpeed,capacityOfBattery,energyConsumptionPer100meters", electricBicycle.getHeaders());
    }

    @Test
    public void testToCSV() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        assertEquals("Colnago,60.0,40.0,35.0,0.2", electricBicycle.toCSV());
    }

    @Test
    public void testGetMaxDistanceIfCapacityOfBatteryIsZero() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 0, 0.2);
        assertEquals(0.0, electricBicycle.getMaxDistance());
    }
}
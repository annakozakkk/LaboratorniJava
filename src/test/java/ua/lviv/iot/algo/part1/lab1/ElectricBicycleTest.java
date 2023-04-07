package ua.lviv.iot.algo.part1.lab1;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ElectricBicycleTest {
    @Test
    public void testMaxDistanceToDriveOnElectricBicycle1() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        assertEquals(175, electricBicycle.getMaxDistance());
    }
 @Test
    public void testDefaultConstructor() {
        var electricBicycle = new ElectricBicycle();
        double maxDistance = electricBicycle.getMaxDistance();
        assertTrue(Double.isNaN(maxDistance));
    }

    @Test
    public void testGetMaxDistanceIfCapacityOfBatteryIsZero() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 0, 0.2);
        assertEquals(0.0, electricBicycle.getMaxDistance());
    }
    @Test
    public void testGetMaxDistanceWhenEnergyConsumptionPer100MetersIsZero() {
        var electricBicycle = new ElectricBicycle("Colnago", 60, 40, 0, 0.0);
        double maxDistance = electricBicycle.getMaxDistance();
        assertTrue(Double.isNaN(maxDistance));
    }
}
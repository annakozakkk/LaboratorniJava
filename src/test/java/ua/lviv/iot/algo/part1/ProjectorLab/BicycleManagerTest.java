package ua.lviv.iot.algo.part1.ProjectorLab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.algo.part1.projector.model.*;
import ua.lviv.iot.algo.part1.projector.manager.BicycleManager;


import java.util.List;

public class BicycleManagerTest {
    private BicycleManager bicycleManager;
    @BeforeEach
    public void setUp() {
        bicycleManager = new BicycleManager();
        Bicycle bicycle1 = new Bicycle("Colnago", 60, 45);
        Bicycle bicycle2 = new Bicycle("Trek", 55, 38);
        ElectricBicycle electricBicycle1 = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        ElectricBicycle electricBicycle2 = new ElectricBicycle("Giant", 70, 30, 45, 0.6);
        ElectricScooter electricScooter1 = new ElectricScooter("Bolt", 30, 15, 2, 15);
        ElectricScooter electricScooter2 = new ElectricScooter("Bolt", 40, 12, 3, 17);
        GyroScooter gyroScooter1 = new GyroScooter("Smart Balance", 30, 10, 20, 36, 0.2);
        GyroScooter gyroScooter2 = new GyroScooter("Smart Balance", 50, 20, 30, 48, 0.5);

        bicycleManager.addBicycles(bicycle1);
        bicycleManager.addBicycles(bicycle2);
        bicycleManager.addBicycles(electricBicycle1);
        bicycleManager.addBicycles(electricBicycle2);
        bicycleManager.addBicycles(electricScooter1);
        bicycleManager.addBicycles(electricScooter2);
        bicycleManager.addBicycles(gyroScooter1);
        bicycleManager.addBicycles(gyroScooter2);
    }
    @Test
    public void testFindTheBicyclesWithMaxSpeedMoreThan() {
        List<AbstractBicycle> result = bicycleManager.findTheBicyclesWithMaxSpeedMoreThan(50);
        Assertions.assertEquals(4, result.size());
        Assertions.assertTrue(result.stream().allMatch(bicycle -> bicycle.getMaxSpeed() > 50));
    }

    @Test
    public void testFindTheBicyclesByBrand() {
        List<AbstractBicycle> result = bicycleManager.findTheBicyclesByBrand("Colnago");
        Assertions.assertEquals(2, result.size());
        for (var abstractBicycle : result) {
            Assertions.assertEquals("Colnago", abstractBicycle.getBrand());
        }
    }
}


package ua.lviv.iot.algo.part1.lab1;
import lombok.ToString;

@ToString(callSuper = true)
public class ElectricBicycle extends AbstractBicycle {
    public ElectricBicycle() { }
    public ElectricBicycle(String brand, double maxSpeed, double currentSpeed, double capacityOfBattery, double energyConsumptionPer100meters) {
        super(brand, maxSpeed, currentSpeed);
        this.capacityOfBattery = capacityOfBattery;
        this.energyConsumptionPer100meters = energyConsumptionPer100meters;
    }

    private double capacityOfBattery;

    private double energyConsumptionPer100meters;

    @Override
    public double getMaxDistance() {
        return capacityOfBattery / energyConsumptionPer100meters;
    }


}
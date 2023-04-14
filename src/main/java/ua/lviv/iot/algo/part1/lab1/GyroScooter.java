package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
@ToString (callSuper = true)
public class GyroScooter extends AbstractBicycle {
    public GyroScooter() { }
    public GyroScooter(final String brand,
                       final double maxSpeed,
                       final double currentSpeed,
                       final double capacityOfBattery,
                       final double batteryVoltage,
                       final double energyConsumptionPer1km) {
        super(brand, maxSpeed, currentSpeed);
        this.batteryVoltage = batteryVoltage;
        this.capacityOfBattery = capacityOfBattery;
        this.energyConsumptionPer1km = energyConsumptionPer1km;
    }


    private double capacityOfBattery;
    private double batteryVoltage;
    private double energyConsumptionPer1km;

    @Override
    public final double getMaxDistance() {
        return (capacityOfBattery * batteryVoltage) / energyConsumptionPer1km;
    }
}

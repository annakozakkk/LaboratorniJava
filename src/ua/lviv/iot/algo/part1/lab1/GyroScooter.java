package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;
@ToString (callSuper = true)

public class GyroScooter extends AbstractBicycle {

    public GyroScooter(String brand, double maxSpeed, double currentSpeed, double capacityOfBattery ,double batteryVoltage,double energyConsumptionPer1km) {
        super(brand, maxSpeed, currentSpeed);
        this.batteryVoltage=batteryVoltage;
        this.capacityOfBattery=capacityOfBattery;
        this.energyConsumptionPer1km=energyConsumptionPer1km;
    }


    private double capacityOfBattery;
    private double batteryVoltage;
    private double energyConsumptionPer1km;

    @Override
    public double getMaxDistance() {
        return (capacityOfBattery * batteryVoltage)/energyConsumptionPer1km;
    }
}


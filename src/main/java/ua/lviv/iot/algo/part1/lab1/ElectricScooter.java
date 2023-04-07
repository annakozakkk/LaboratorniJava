package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)

public class ElectricScooter extends AbstractBicycle {

    public ElectricScooter(String brand, double maxSpeed, double currentSpeed, double timeToDriveOnOneBatteryCharge, double averageSpeed) {
        super(brand, maxSpeed, currentSpeed);
        this.timeToDriveOnBatteryCharge = timeToDriveOnOneBatteryCharge;
        this.averageSpeed = averageSpeed;
    }

    private double timeToDriveOnBatteryCharge;
    private double averageSpeed;
    @Override
    public double getMaxDistance() {
        return timeToDriveOnBatteryCharge * averageSpeed;
    }
}
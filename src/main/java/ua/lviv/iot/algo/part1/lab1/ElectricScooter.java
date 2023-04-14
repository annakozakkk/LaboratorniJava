package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)

public class ElectricScooter extends AbstractBicycle {

    public ElectricScooter(final String brand,
                           final double maxSpeed,
                           final double currentSpeed,
                           final double timeToDriveOnOneBatteryCharge,
                           final double averageSpeed) {
        super(brand, maxSpeed, currentSpeed);
        this.timeToDriveOnBatteryCharge = timeToDriveOnOneBatteryCharge;
        this.averageSpeed = averageSpeed;
    }

    private double timeToDriveOnBatteryCharge;
    private double averageSpeed;
    @Override
    public final double getMaxDistance() {
        return timeToDriveOnBatteryCharge * averageSpeed;
    }
}

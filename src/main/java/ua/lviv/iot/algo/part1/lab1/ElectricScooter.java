package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.ToString;

@Getter
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

    public static final String HEADERS = "timeToDriveOnBatteryCharge,averageSpeed";

    @Override
    public final double getMaxDistance() {
        return timeToDriveOnBatteryCharge * averageSpeed;
    }

    public final String getHeaders() {
        return super.getHeaders() + "," + HEADERS;
    }

    public final String toCSV() {
        return super.toCSV() + "," + getTimeToDriveOnBatteryCharge() + "," + getAverageSpeed();
    }
}

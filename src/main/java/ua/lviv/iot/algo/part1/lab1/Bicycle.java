package ua.lviv.iot.algo.part1.lab1;

import lombok.ToString;

@ToString(callSuper = true)

public class Bicycle extends AbstractBicycle {
    public Bicycle(final String brand, final double maxSpeed,
                   final double currentSpeed) {
        super(brand, maxSpeed, currentSpeed);
    }

    @Override
    public final double getMaxDistance() {
        return Integer.MAX_VALUE;
    }

    public final String getHeaders() {
        return super.getHeaders();
    }

    public final String toCSV() {
        return super.toCSV();
    }
}

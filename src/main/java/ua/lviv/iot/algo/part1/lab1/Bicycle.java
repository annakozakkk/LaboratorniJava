package ua.lviv.iot.algo.part1.lab1;
import lombok.ToString;
@ToString (callSuper = true)

public class Bicycle extends AbstractBicycle {
    public Bicycle(String brand, double maxSpeed, double currentSpeed) {
        super(brand, maxSpeed, currentSpeed);
    }
    @Override
    public double getMaxDistance() {
        return Integer.MAX_VALUE;
    }



}


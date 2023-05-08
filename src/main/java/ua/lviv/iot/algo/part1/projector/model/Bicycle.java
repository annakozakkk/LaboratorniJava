package ua.lviv.iot.algo.part1.projector.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString (callSuper = true)
public class Bicycle extends AbstractBicycle {
    private Integer id;


    public Bicycle(String brand, double maxSpeed, double currentSpeed) {
        super(brand, maxSpeed, currentSpeed);
    }

    @Override
    public double getMaxDistance() {
        return Integer.MAX_VALUE;
    }
}
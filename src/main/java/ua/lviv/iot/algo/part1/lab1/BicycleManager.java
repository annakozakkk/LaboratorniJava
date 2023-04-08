package ua.lviv.iot.algo.part1.lab1;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor

public class BicycleManager {
    private List<AbstractBicycle> bicycles = new ArrayList<>();

    public void addBicycles(final AbstractBicycle bicycle) {
        bicycles.add(bicycle);
    }

    public List<AbstractBicycle> findTheBicyclesWithMaxSpeedMoreThan(final double maxSpeed) {
        return bicycles.stream()
                .filter(bicycle -> bicycle.getMaxSpeed() > maxSpeed)
                .collect(Collectors.toList());

    }

    public List<AbstractBicycle> findTheBicyclesByBrand(final String brand) {
        return bicycles.stream()
                .filter(bicycle -> Objects.equals(bicycle.getBrand(), brand))
                .collect(Collectors.toList());

    }

}
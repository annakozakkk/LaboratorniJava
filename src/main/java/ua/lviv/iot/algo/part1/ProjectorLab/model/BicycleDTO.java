package ua.lviv.iot.algo.part1.ProjectorLab.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BicycleDTO {
    private String brand;
    private double maxSpeed;
    private double currentSpeed;
    private Integer id;
}



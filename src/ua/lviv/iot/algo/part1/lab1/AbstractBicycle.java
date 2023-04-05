package ua.lviv.iot.algo.part1.lab1;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractBicycle{
    protected String brand;
    protected double maxSpeed;
    protected double currentSpeed;
    public abstract double getMaxDistance();


};


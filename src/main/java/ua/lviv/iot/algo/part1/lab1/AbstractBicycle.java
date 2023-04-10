package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractBicycle {
   private  String brand;
   private double maxSpeed;
   private double currentSpeed;
    public abstract double getMaxDistance();


}

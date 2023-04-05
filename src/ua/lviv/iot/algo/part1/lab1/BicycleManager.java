package ua.lviv.iot.algo.part1.lab1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Setter
@Getter
@NoArgsConstructor
@ToString
public class BicycleManager {
    private List<AbstractBicycle> bicycles = new ArrayList<>();

    public void addBicycles(final AbstractBicycle bicycle) {
        bicycles.add(bicycle);
    }

    public  List<AbstractBicycle> findTheBicyclesWithMaxSpeedMoreThan(double maxSpeed) {
        return bicycles.stream()
                       .filter(bicycle -> bicycle.getMaxSpeed() > maxSpeed)
                       .collect(Collectors.toList());

    }

    public List<AbstractBicycle> findTheBicyclesByBrand(String brand) {
        return bicycles.stream()
                       .filter(bicycle -> Objects.equals(bicycle.getBrand(), brand))
                       .collect(Collectors.toList());

    }


    public static void main(String[] arg) {
        List<AbstractBicycle> bicycles= new ArrayList<>();
        Bicycle bicycle1 = new Bicycle("Colnago", 60, 45);
        Bicycle bicycle2 = new Bicycle("Trek", 55, 38);
        ElectricBicycle electricBicycle1 = new ElectricBicycle("Colnago", 60, 40, 35, 0.2);
        ElectricBicycle electricBicycle2 = new ElectricBicycle("Giant", 70, 30, 45, 0.6);
        ElectricScooter electricScooter1=new ElectricScooter("Bolt",30,15,2,15);
        ElectricScooter electricScooter2=new ElectricScooter("Bolt",40,12,3,17);
        GyroScooter gyroScooter1=new GyroScooter("Smart Balance",30,10,20,36,0.2);
        GyroScooter gyroScooter2=new GyroScooter("Smart Balance",50,20,30,48,0.5);

        bicycles.add(bicycle1);
        bicycles.add(bicycle2);
        bicycles.add(electricBicycle1);
        bicycles.add(electricScooter1);
        bicycles.add(electricBicycle2);
        bicycles.add(electricScooter2);
        bicycles.add(gyroScooter1);
        bicycles.add(gyroScooter2);

        for (var bicycle : bicycles) {
            System.out.println(bicycle.toString());
        }
        BicycleManager bicycleManager=new BicycleManager();
        bicycleManager.addBicycles(bicycle1);
        bicycleManager.addBicycles(bicycle2);
        bicycleManager.addBicycles(electricBicycle1);
        bicycleManager.addBicycles(electricBicycle2);
        bicycleManager.addBicycles(electricScooter1);
        bicycleManager.addBicycles(electricScooter2);
        bicycleManager.addBicycles(gyroScooter1);
        bicycleManager.addBicycles(gyroScooter2);


        System.out.println("Bicycles, with max speed more than 50:");
        List<AbstractBicycle> result = bicycleManager.findTheBicyclesWithMaxSpeedMoreThan(50);
        for (AbstractBicycle bicycle : result) {
            System.out.println("\n" + bicycle);
        }
        System.out.println("Bicycles by Brand");
        List<AbstractBicycle> result1 = bicycleManager.findTheBicyclesByBrand("Colnago");
        for (AbstractBicycle bicycle : result1) {
            System.out.println("\n" + bicycle);
        }

    }
}


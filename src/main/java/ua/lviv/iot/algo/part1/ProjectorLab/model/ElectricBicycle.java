package ua.lviv.iot.algo.part1.ProjectorLab.model;

import lombok.ToString;

@ToString(callSuper = true)
public class ElectricBicycle extends AbstractBicycle {
    //public ElectricBicycle(){}
    public ElectricBicycle(String brand, double maxSpeed, double currentSpeed, double capacityOfBattery,double energyConsumptionPer100meters) {
        super(brand, maxSpeed, currentSpeed);
        this.capacityOfBattery = capacityOfBattery;
        this.energyConsumptionPer100meters=energyConsumptionPer100meters;
    }
     private final double capacityOfBattery;
    private final double energyConsumptionPer100meters;
    public static final String HEADERS = "capacityOfBattery,energyConsumptionPer100meters";
    @Override
    public double getMaxDistance() {
        return capacityOfBattery*energyConsumptionPer100meters;
    }
    public final String getHeaders() {
        return super.getHeaders() + "," + HEADERS;
    }

    public final String toCSV() {
        return super.toCSV() + "," +capacityOfBattery +","+energyConsumptionPer100meters;
    }
}

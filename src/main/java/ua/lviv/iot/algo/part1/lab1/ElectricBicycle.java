
package ua.lviv.iot.algo.part1.lab1;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString(callSuper = true)
public class ElectricBicycle extends AbstractBicycle {
    public ElectricBicycle() { }
    public ElectricBicycle(final String brand, final double maxSpeed,
                           final double currentSpeed,
                           final double capacityOfBattery,
                           final double energyConsumptionPer100meters) {
        super(brand, maxSpeed, currentSpeed);
        this.capacityOfBattery = capacityOfBattery;
        this.energyConsumptionPer100meters = energyConsumptionPer100meters;
    }
    private double capacityOfBattery;
    private double energyConsumptionPer100meters;
    public static final String HEADERS = "capacityOfBattery,energyConsumptionPer100meters";
    @Override
    public final double getMaxDistance() {
        return capacityOfBattery / energyConsumptionPer100meters;
    }
    public final String getHeaders() {
        return super.getHeaders() + "," + HEADERS;
    }
    public final String toCSV() {
        return super.toCSV() + "," + getCapacityOfBattery() + "," + getEnergyConsumptionPer100meters();
    }
}

package ua.lviv.iot.algo.part1.lab1;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bicycle {

    private static Bicycle instance = new Bicycle("moutain", "Trek", 40, 20);

    public static Bicycle getInstance() {
        return instance;
    }

    private String type="road";
    private String brand="Giant";
    private int maxSpeed=50;
    private int currentSpeed=22;


    public int accelerate(int speed) {
        if (speed < maxSpeed) {
            currentSpeed = currentSpeed + speed;
        }
        return currentSpeed;
    }

    public int brake() {

        return currentSpeed=0;
    }
    public double increasePrice(double price)
    {
        return price+50;
    }
    public static void main(String[] arg) {
        Bicycle[] bicycles= new Bicycle[4];
        bicycles[0]=Bicycle.getInstance();
        bicycles[1]=Bicycle.getInstance();
        bicycles[2]=new Bicycle("moutain","Colnago",45,34);
        bicycles[3]=new Bicycle();

        for(Bicycle i:bicycles){
            System.out.println(i.toString());
        }
    }
}
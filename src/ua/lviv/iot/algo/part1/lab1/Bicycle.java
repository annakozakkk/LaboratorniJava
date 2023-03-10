package ua.lviv.iot.algo.part1.lab1;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bicycle {

    private static Bicycle instance = new Bicycle("mountain", "Trek", 40.8, 20.8);

    public static Bicycle getInstance() {
        return instance;
    }

    private String type;
    private String brand;
    private double maxSpeed;
    private double currentSpeed;


    public double accelerate(int speed) {
        if (speed < maxSpeed) {
            currentSpeed = currentSpeed + speed;

        }
        return currentSpeed;
    }

    public double brake() {

        return currentSpeed=0;
    }
      double slowDown(double speed){
              if (speed<currentSpeed) {
                  currentSpeed = currentSpeed-speed;
              }
              return currentSpeed;
          }


    public static void main(String[] arg) {
        Bicycle[] bicycles= new Bicycle[4];
        bicycles[0]=Bicycle.getInstance();
        bicycles[1]=Bicycle.getInstance();
        bicycles[2]=new Bicycle("mountain","Colnago",45,34);
        bicycles[3]=new Bicycle();

        for(Bicycle i:bicycles){
            System.out.println(i.toString());
        }
        System.out.println("The speed of bicycle 'Trek' after accelerating  is " +bicycles[1].accelerate(8));
        System.out.println("The bicycle 'Trek' was braked to a complete stop,speed is: " + bicycles[1].brake());
        System.out.println("The speed of the bicycle 'Colnago' after it has been slowed down is: "+bicycles[2].slowDown(23));

    }
}
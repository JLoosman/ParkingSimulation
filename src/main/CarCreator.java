import java.util.ArrayList;
import java.util.Scanner;

public class CarCreator {

   private static final ArrayList<Car> cars = new ArrayList<>();

    public static Car createCar() {
       Car car = new Car();
       cars.add(car);

       return car;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    //remove car from ArrayList
    public static void removeCar(Car car) {
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).equals(car)) {
                cars.remove(i);
                return;
            }
        }
    }
}
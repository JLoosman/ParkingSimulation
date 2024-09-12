import java.util.ArrayList;
import java.util.stream.Stream;

public class CarCreator {

   private final ArrayList<Car> cars = new ArrayList<>();

    public Car createCar() {
       Car car = new Car();
       cars.add(car);

       return car;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    //remove car from ArrayList
    public void removeCar(Car car) {
        cars.remove(cars.stream().filter(c -> c.equals(car)).findFirst().get());
    }
}
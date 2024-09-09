import java.util.ArrayList;

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
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).equals(car)) {
                cars.remove(i);
                return;
            }
        }
    }
}
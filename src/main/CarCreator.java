import java.util.ArrayList;
import java.util.Scanner;

public class CarCreator {

   private static ArrayList<Car> cars = new ArrayList<>();

    public static Car createCar() {
       Car car = new Car();
       cars.add(car);

       return car;
    }

    // static methods to get a specific car out of all of them
    public static Car chooseCar() {
        for(int i = 0; i < cars.size(); i++) {
            System.out.println(i + 1 + ") " + cars.get(i).getId());
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your main.Car...");
        String userChosenID = scan.nextLine();
        if(userChosenID.isEmpty() || !Character.isDigit(userChosenID.charAt(0)) || Integer.parseInt(userChosenID) <= 0 || Integer.parseInt(userChosenID) > cars.size()) {
            System.out.println("no valid id provided");
            return null;
        }

        return cars.get(Integer.parseInt(userChosenID) - 1);
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

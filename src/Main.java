import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");

        Parkhaus parkhaus = new Parkhaus(1);

        boolean loop = true;

        while (loop) {
            System.out.println("\n\n\n");
            System.out.println("Free places: " + Parkhaus.getFree());

            System.out.println("[1] park a new Car       [2] pay a ticket       [3] release a car       [exit] close session");
            System.out.println("Choose your option...");

            String result = scan.nextLine();

            switch (result) {
                case "1": {
                    Car car = new Car();
                    parkhaus.parken(car);
                    break;
                }
                case "2": {
                    String id = Car.chooseCar();
                    if (id.isEmpty()) { continue; }
                    Car car = parkhaus.getCarById(id);

                    parkhaus.payTicket(car);
                    break;
                }
                case "3": {
                    String id = Car.chooseCar();
                    if(id.isEmpty()) { continue; }
                    Car car = parkhaus.getCarById(id);

                    parkhaus.ausparken(car);
                    break;
                }

                case "exit": {
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("Please choose a valid option!");
                    break;
                }
            }
        }
    }
}
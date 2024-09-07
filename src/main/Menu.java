import java.util.Scanner;

public class Menu {
    Parkhaus parkhaus;

    public Menu(Parkhaus parkhaus) {
        this.parkhaus = parkhaus;
    }
    public void start() {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");

        while (true) {
            System.out.println("\n\n\n");
            System.out.println("Free places: " + Parkhaus.getFree());

            System.out.println("[1] park a new Car       [2] pay a ticket       [3] release a car       [exit] close session");
            System.out.println("Choose your option...");

            String result = scan.nextLine();

            switch (result) {
                case "1": {
                    Car car = CarCreator.createCar();

                    parkhaus.parken(car);
                    break;
                }
                case "2": {
                    Car car = CarCreator.chooseCar();
                    if (car == null) { continue; }

                    parkhaus.payTicket(car);
                    break;
                }
                case "3": {
                    Car car = CarCreator.chooseCar();
                    if(car == null) { continue; }

                    parkhaus.ausparken(car);
                    break;
                }

                case "exit": {
                    System.exit(0);
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

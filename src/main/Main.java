// written by Jesiah Loosman

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");

        int floorCount = 1;
        Parkhaus parkhaus = new Parkhaus(floorCount);


        while (true) {
            System.out.println("\n\n\n");
            System.out.println("Free places: " + Parkhaus.getFree());

            System.out.println("[1] park a new main.Car       [2] pay a ticket       [3] release a car       [exit] close session");
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
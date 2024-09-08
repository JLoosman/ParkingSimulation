import java.util.Scanner;

public class Menu {
    Parkhaus parkhaus;
    UI ui;

    public Menu(Parkhaus parkhaus, UI ui) {
        this.parkhaus = parkhaus;
        this.ui = ui;
    }

    public void start() {

        while (true) {
            System.out.println("\n\n\n");
            ui.printMessage("Free places: " + Parkhaus.getFree());

            ui.printMessage("[1] park a new Car       [2] pay a ticket       [3] release a car       [exit] close session");

            String result = ui.getString("Choose your option...");

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
                    ui.printMessage("Please choose a valid option!");
                    break;
                }
            }
        }
    }
}

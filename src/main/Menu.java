import java.util.ArrayList;

public class Menu {
    private final Parkhaus parkhaus;
    private final CarCreator carCreator;
    private final UI ui;

    public Menu(Parkhaus parkhaus, CarCreator carCreator, UI ui) {
        this.parkhaus = parkhaus;
        this.carCreator = carCreator;
        this.ui = ui;
    }

    public void start() {

        while (true) {
            ui.printMessage("\n\n\n");
            ui.printMessage("Free places: " + Parkhaus.getFree());
            ui.printMessage("[1] park a new Car       [2] pay a ticket       [3] release a car       [exit] close session");

            String result = ui.getString("Choose your option...");

            switch (result) {
                case "1": {
                    Car car = carCreator.createCar();

                    if(parkhaus.parken(car) == -1) {
                        ui.printMessage("Couldn't find a parking lot");
                       carCreator.removeCar(car);
                    } else {
                        ui.printMessage("Parked successfully");
                    }
                    break;
                }
                case "2": {
                    Car car = chooseCar();
                    if (car == null) { continue; }

                    double price = car.getTicket().pay();
                    ui.printMessage("Dein Aufenthalt kostet " + price + " CHF");

                    break;
                }
                case "3": {
                    Car car = chooseCar();
                    if(car == null) { continue; }

                    if (parkhaus.ausparken(car) == -1) {
                        ui.printMessage("You have to pay your ticket");
                    } else {
                        carCreator.removeCar(car);
                        ui.printMessage("Car released successfully");
                    }
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

    private Car chooseCar() {
        ArrayList<Car> cars = carCreator.getCars();

        ui.displayCars(cars);
        String id = ui.getString("Choose your car...");

        if(id.isEmpty() || !Character.isDigit(id.charAt(0)) || Integer.parseInt(id) <= 0 || Integer.parseInt(id) > cars.size()) {
            ui.printMessage("Please choose a valid id!");
            return null;
        }

        return cars.get(Integer.parseInt(id) - 1);
    }
}

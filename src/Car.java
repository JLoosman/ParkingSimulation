import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Car {
    private String id = UUID.randomUUID().toString();
    private Ticket ticket;
    private static ArrayList<String> cars = new ArrayList<>();


    public String getId() {
        return id;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    // static methods to get a specific car out of every instance of a car
    public static String chooseCar() {

        for(int i = 0; i < cars.size(); i++) {
            System.out.println(i + 1 + ") " + cars.get(i));
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your Car...");
        String userChosenID = scan.nextLine();
        if(userChosenID.isEmpty() || !Character.isDigit(userChosenID.charAt(0)) || Integer.parseInt(userChosenID) <= 0 || Integer.parseInt(userChosenID) > cars.size()) {
            System.out.println("no valid id provided");
            return "";
        }

        return cars.get(Integer.parseInt(userChosenID) - 1);
    }

    //remove car id from ArrayList
    public static void removeCar(String id) {
        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).equals(id)) {
                cars.remove(i);
                return;
            }
        }
    }

    public Car() {
        cars.add(this.id);
    }
}
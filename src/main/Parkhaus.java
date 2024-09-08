import java.util.ArrayList;
import java.util.Scanner;

public class Parkhaus {

    Eintrittsschranke eintrittsschranke = new Eintrittsschranke();
    Austrittschranke austrittschranke1 = new Austrittschranke();
    Austrittschranke austrittschranke2 = new Austrittschranke();

    private static ArrayList<Stockwerk> stockwerke = new ArrayList<>();

    public Parkhaus (int anzahlStockwerke) {
        for(int i = 0; i < anzahlStockwerke; i++) {
            stockwerke.add(new Stockwerk());
        }
    }

    public static int getFree() {
        int count = 0;
        for (Stockwerk stockwerk : stockwerke) {
            count += stockwerk.countFree();
        }
        return count;
    }

    public void payTicket(Car car) {
        for (Stockwerk stockwerk : stockwerke) {
            if (stockwerk.getCar(car) != null) {
                stockwerk.payTicket(car.getTicket());
            }
        }
    }

    public int parken(Car car) {
        if(eintrittsschranke.passGate(car) == -1) { return -1; }

        for (Stockwerk stockwerk : stockwerke) {
            if (stockwerk.parkCar(car) == 0) { return 0; }
        }
        return -1;
    }

    public void ausparken(Car car) {

        Scanner scan = new Scanner(System.in);
        System.out.println("do you want to use exit 1 or exit 2?");
        String result = scan.nextLine();

        if(result.equals("1") || result.equals("2")) {
           if (result.equals("1") ? austrittschranke1.passGate(car) == -1 : austrittschranke2.passGate(car) == -1) { return; }
        } else {
            System.out.println("choose a valid solution");
            return;
        }

        for (Stockwerk stockwerk : stockwerke) {
            if (stockwerk.releaseCar(car) == 0) { return; }
        }
    }
}
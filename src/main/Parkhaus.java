import java.util.ArrayList;

public class Parkhaus {

    Eintrittsschranke eintrittsschranke = new Eintrittsschranke();
    Austrittschranke austrittschranke = new Austrittschranke();

    private static ArrayList<Stockwerk> stockwerke = new ArrayList<>();

    public Parkhaus (int anzahlStockwerke) {
        for(int i = 0; i < anzahlStockwerke; i++) {
            stockwerke.add(new Stockwerk());
        }
    }

    public static int getFree() {
        return stockwerke.stream()
                .mapToInt(Stockwerk::countFree)
                .sum();
    }

    public int parken(Car car) {
        if(eintrittsschranke.passGate(car) == -1) { return -1; }

        for (Stockwerk stockwerk : stockwerke) {
            if (stockwerk.parkCar(car) == 0) { return 0; }
        }
        return -1;
    }

    public int ausparken(Car car) {
        if(austrittschranke.passGate(car) == -1) { return -1; }

        for (Stockwerk stockwerk : stockwerke) {
            if (stockwerk.releaseCar(car) == 0) { return 0; }
        }

        return -1;
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class Stockwerk {
    private ArrayList<Parkplatz> parkplätze = new ArrayList<>();

    public Stockwerk() {
        for(int i = 0; i < 20; i++) {
            parkplätze.add(new Parkplatz());
        }
    }

    public int countFree() {
        return (int) parkplätze.stream()
                .filter(parkplatz -> parkplatz.getParkedCar() == null)
                .count();
    }

    public int parkCar(Car car) {
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                parkplatz.setParkedCar(car);
                return 0;
            }
        }
        return -1;
    }

    public int releaseCar(Car car) {
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                continue;
            }
            if (parkplatz.getParkedCar().equals(car)) {
                parkplatz.setParkedCar(null);
                return 0;
            }
        }
        return -1;
    }
}
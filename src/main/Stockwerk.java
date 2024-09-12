import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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
        Optional<Parkplatz> parkplatz = parkplätze.stream()
                .filter(p -> p.getParkedCar() == null)
                .findFirst();

        if(parkplatz.isPresent()) {
            parkplatz.get().setParkedCar(car);
            return 0;
        } else { return -1; }
    }

    public int releaseCar(Car car) {
        Optional<Parkplatz> parkplatz = parkplätze.stream()
                .filter(p -> p.getParkedCar() == car)
                .findFirst();

        if(parkplatz.isPresent()) {
            parkplatz.get().setParkedCar(null);
            return 0;
        } else { return -1; }
    }
}
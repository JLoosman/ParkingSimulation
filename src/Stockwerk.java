import java.util.Arrays;

public class Stockwerk {
    private Parkplatz[] parkplätze = new Parkplatz[20];
    private Kasse kasse = new Kasse();

    public Stockwerk() {
        for(int i = 0; i < parkplätze.length; i++) {
            parkplätze[i] = new Parkplatz();
        }
    }

    public int countFree() {
        int count = 0;
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                count++;
            }
        }
        return count;
    }

    public Car getCar(Car car) {
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                continue;
            }
            if (parkplatz.getParkedCar().equals(car)) {
                return parkplatz.getParkedCar();
            }
        }
        return null;
    }

    public void payTicket(Ticket ticket) {
        kasse.payTicket(ticket);
    }

    public int parkCar(Car car) {
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                parkplatz.setParkedCar(car);
                System.out.println("successfully parked the car");
                return 0;
            }
        }
        System.out.println("Couldnt find a parking lot");
        return -1;
    }

    public int releaseCar(Car car) {
        for (Parkplatz parkplatz : parkplätze) {
            if (parkplatz.getParkedCar() == null) {
                continue;
            }
            if (parkplatz.getParkedCar().equals(car)) {
                parkplatz.setParkedCar(null);
                CarCreator.removeCar(car);
                System.out.println("Successfully released car");
                return 0;
            }
        }

        System.out.println("Couldnt find a car to release");
        return -1;
    }
}
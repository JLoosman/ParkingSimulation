public class Stockwerk {
    private Parkplatz[] parkplätze = new Parkplatz[20];

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
                CarCreator.removeCar(car);
                return 0;
            }
        }
        return -1;
    }
}
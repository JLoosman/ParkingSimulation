public class Eintrittsschranke extends Schranke {


    public int passGate(Car car) {
        if (Parkhaus.getFree() <= 0) {
            System.out.println("No Free Parking lots left");
            CarCreator.removeCar(car);
            return -1;
        }

        System.out.println("Printing ticket...");
        car.setTicket(new Ticket());
        System.out.println("Passed the gate");
        return 0;
    }
}
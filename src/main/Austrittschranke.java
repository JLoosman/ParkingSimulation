public class Austrittschranke extends Schranke{

    public int passGate(Car car) {
        if(!car.getTicket().isPaid()) {
            System.out.println("You have to pay your ticket");
            return -1;
        }
        return 0;
    }

    public static class Eintrittsschranke extends Schranke {


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
}

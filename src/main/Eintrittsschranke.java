public class Eintrittsschranke extends Schranke {


    public int passGate(Car car) {
        if (Parkhaus.getFree() <= 0) {
            return -1;
        }

        car.setTicket(new Ticket());
        return 0;
    }
}
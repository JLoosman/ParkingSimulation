public class Austrittschranke extends Schranke{

    public int passGate(Car car) {
        return car.getTicket().isPaid() ? 0 : -1;
    }
}
public class Austrittschranke extends Schranke{

    public int passGate(Car car) {
        if(!car.getTicket().isPaid()) {
            return -1;
        }
        return 0;
    }
}
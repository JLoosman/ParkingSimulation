public class Austrittschranke extends Schranke{

    public int passGate(Car car) {
        if(!car.getTicket().isPaid()) {
            System.out.println("You have to pay your ticket");
            return -1;
        }
        return 0;
    }
}

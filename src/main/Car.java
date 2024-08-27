import java.util.UUID;

public class Car {
    private String id = UUID.randomUUID().toString();
    private Ticket ticket;

    public String getId() {
        return id;
    }
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
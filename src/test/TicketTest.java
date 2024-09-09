import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void payTest() {
        Ticket ticket = new Ticket();
        ticket.pay();
        assertEquals(-1, ticket.pay());
        assertTrue(ticket.isPaid());
    }
}
public class Kasse {

    public void payTicket(Ticket ticket) {
        if(ticket.isPaid()) {
            System.out.println("You already paid for this ticket");
            return;
        }
        long startDate = ticket.getStartDate();
        long endDate = System.currentTimeMillis();

        double seconds = (double) (endDate - startDate) / 1000;

        System.out.println("Du hast " + seconds + " Sekunden geparkt");

        double pricePerSecond = 2.5;

        double price = Math.round(seconds * pricePerSecond * 100) / 100;

        System.out.println("Ihr Aufenthalt kostet " + price + " CHF");

        ticket.setPaid(true);
    }
}
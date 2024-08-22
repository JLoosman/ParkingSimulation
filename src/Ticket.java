public class Ticket {

    private long startDate = System.currentTimeMillis();
    private boolean isPaid = false;

    public boolean isPaid() {
        return isPaid;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
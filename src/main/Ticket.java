public class Ticket {

    private final long startDate = System.currentTimeMillis();
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

    public double pay() {
       if(this.isPaid()) { return -1 ; }

        long endDate = System.currentTimeMillis();

        double seconds = (double) (endDate - this.getStartDate()) / 1000;
        double pricePerSecond = 2.5;
        double price = (double) Math.round(seconds * pricePerSecond * 100) / 100;

        this.setPaid(true);

        return price;
    }
}
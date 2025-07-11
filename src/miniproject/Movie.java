package miniproject;

public class Movie {
    public int id;
    public String title;
    public String showTime;
    public int availableSeats;
    public double pricePerTicket;

    public Movie(int id, String title, String showTime, int availableSeats, double pricePerTicket) {
        this.id = id;
        this.title = title;
        this.showTime = showTime;
        this.availableSeats = availableSeats;
        this.pricePerTicket = pricePerTicket;
    }

    public void displayInfo() {
        System.out.println(id + ". " + title + " | Time: " + showTime +
                " | Seats: " + availableSeats + " | Price: ₹" + pricePerTicket);
    }
}

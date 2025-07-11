package miniproject;

public class Booking {
    public Movie movie;
    public int seatsBooked;
    public double totalCost;

    public Booking(Movie movie, int seatsBooked) {
        this.movie = movie;
        this.seatsBooked = seatsBooked;
        this.totalCost = movie.pricePerTicket * seatsBooked;
    }

    public void displayTicket() {
        System.out.println("\n🎟️ Booking Confirmed!");
        System.out.println("Movie: " + movie.title);
        System.out.println("Show Time: " + movie.showTime);
        System.out.println("Seats Booked: " + seatsBooked);
        System.out.println("Total Cost: ₹" + totalCost);
    }
}
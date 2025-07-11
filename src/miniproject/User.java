package miniproject;
import java.util.List;
import java.util.Scanner;

public class User {
    public static Booking lastBooking = null;

    public static void showUserMenu(List<Movie> movies, Scanner sc) {
        int choice;
        do {
            System.out.println("\n👤 User Menu");
            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Last Booking");
            System.out.println("4. View Seats Available");
            System.out.println("5. Back");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> Admin.displayMovies(movies);
                case 2 -> bookTicket(movies, sc);
                case 3 -> viewLastBooking();
                case 4 -> viewAvailableSeats(movies);
                case 5 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }

    public static void bookTicket(List<Movie> movies, Scanner sc) {
        if (movies.isEmpty()) {
            System.out.println("❌ No movies available.");
            return;
        }

        Admin.displayMovies(movies);
        System.out.print("Enter Movie ID: ");
        int id = sc.nextInt();
        Movie selected = null;

        for (Movie m : movies) {
            if (m.id == id) {
                selected = m;
                break;
            }
        }

        if (selected == null) {
            System.out.println("❌ Movie not found.");
            return;
        }

        System.out.print("Enter number of seats: ");
        int seats = sc.nextInt();

        if (seats <= 0 || seats > selected.availableSeats) {
            System.out.println("❌ Invalid seat count.");
            return;
        }

        selected.availableSeats -= seats;
        lastBooking = new Booking(selected, seats);
        lastBooking.displayTicket();
    }

    public static void viewLastBooking() {
        if (lastBooking != null) {
            lastBooking.displayTicket();
        } else {
            System.out.println("No bookings yet.");
        }
    }

    public static void viewAvailableSeats(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("📭 No movies available.");
            return;
        }

        System.out.println("\n🎟️ Current Seat Availability:");
        for (Movie m : movies) {
            System.out.println(m.id + ". " + m.title + " | Time: " + m.showTime + " | Seats Available: " + m.availableSeats);
        }
    }
}
package miniproject;

import java.util.List;
import java.util.Scanner;

public class Admin {
    public static void login(List<Movie> movies, Scanner sc, int[] movieIdCounter) {
        System.out.print("Enter admin username: ");
        String username = sc.next();
        System.out.print("Enter admin password: ");
        String password = sc.next();

        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("✅ Login successful.");
            showAdminMenu(movies, sc, movieIdCounter);
        } else {
            System.out.println("❌ Invalid admin credentials.");
        }
    }

    public static void showAdminMenu(List<Movie> movies, Scanner sc, int[] movieIdCounter) {
        int choice;
        do {
            System.out.println("\n🛠️ Admin Menu");
            System.out.println("1. Add Movie");
            System.out.println("2. View Movies");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addMovie(movies, sc, movieIdCounter);
                case 2 -> displayMovies(movies);
                case 3 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);
    }

    public static void addMovie(List<Movie> movies, Scanner sc, int[] movieIdCounter) {
        sc.nextLine(); // flush
        System.out.print("Enter movie title: ");
        String title = sc.nextLine();
        System.out.print("Enter show time: ");
        String time = sc.nextLine();
        System.out.print("Enter available seats: ");
        int seats = sc.nextInt();
        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        movies.add(new Movie(movieIdCounter[0]++, title, time, seats, price));
        System.out.println("✅ Movie added.");
    }

    public static void displayMovies(List<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("📭 No movies available.");
            return;
        }
        System.out.println("\n📽️ Available Movies:");
        for (Movie m : movies) {
            m.displayInfo();
        }
    }
}
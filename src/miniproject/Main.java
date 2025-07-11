package miniproject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        int[] movieIdCounter = {1}; // Using array to simulate pass-by-reference
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n🎬 Movie Ticket Booking System");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your role: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> Admin.login(movies, sc, movieIdCounter);
                case 2 -> User.showUserMenu(movies, sc);
                case 3 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 3);

        sc.close();
    }
}
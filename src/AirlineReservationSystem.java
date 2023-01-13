import java.util.Scanner;

public class AirlineReservationSystem {
    // Number of seats available on the plane
    private static final int NUM_SEATS = 10;

    // Array of booleans representing the availability of each seat
    private final boolean[] seats = new boolean[NUM_SEATS];

    public static void main(String[] args) {
        // Create a new instance of the AirlineReservationSystem class
        AirlineReservationSystem airlineReservationSystem = new AirlineReservationSystem();

        // Run the main menu loop
        airlineReservationSystem.mainMenu();
    }

    // Main menu for the airline reservation system
    private void mainMenu() {
        // Create a new scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Flag indicating whether the user has chosen to quit
        boolean quit = false;

        // Loop until the user chooses to quit
        while (!quit) {
            // Print the main menu
            System.out.println("Airline Reservation System");
            System.out.println("1. Check seat availability");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice = scanner.nextInt();

            // Process the user's choice
            switch (choice) {
                case 1 -> checkAvailability();
                case 2 -> reserveSeat(scanner);
                case 3 -> cancelReservation(scanner);
                case 4 -> quit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Function to check the availability of seats on the plane
    private void checkAvailability() {
        // Print the header for the availability report
        System.out.println("Seat availability:");

        // Loop through each seat and print its availability
        for (int i = 0; i < NUM_SEATS; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Reserved" : "Available"));
        }
    }

    // Function to reserve a seat on the plane
    private void reserveSeat(Scanner scanner) {
        // Print the header for the reservation prompt
        System.out.println("Reserve a seat:");

        // Loop through each seat and print its availability
        for (int i = 0; i < NUM_SEATS; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Reserved" : "Available"));
        }

        // Prompt the user to enter the seat number they want to reserve
        System.out.print("Enter the seat number you want to reserve: ");
        int seatNum = scanner.nextInt();

        // Check if the seat is already reserved
        if (seats[seatNum - 1]) {
            System.out.println("Seat " + seatNum + " is already reserved. Please choose another seat.");
            return;
        }

        // Check if the seat number is valid
        if (seatNum > NUM_SEATS) {
            System.out.println("Invalid seat number. Please choose a seat between 1 and " + NUM_SEATS);
            return;
        }

        // Reserve the seat
        seats[seatNum - 1] = true;
        System.out.println("Seat " + seatNum + " has been reserved. Thank you.");
    }

    // Function to cancel a seat reservation on the plane
    private void cancelReservation(Scanner scanner) {

        // Print the header for the cancellation prompt
        System.out.println("Cancel a reservation:");

        // Loop through each seat and print its availability
        for (int i = 0; i < NUM_SEATS; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] ? "Reserved" : "Available"));
        }

        // Prompt the user to enter the seat number they want to cancel
        System.out.print("Enter the seat number you want to cancel: ");
        int seatNum = scanner.nextInt();

        // Check if the seat is already available
        if (!seats[seatNum - 1]) {
            System.out.println("Seat " + seatNum + " is already available. No reservation to cancel.");
            return;
        }



        // Cancel the reservation
        seats[seatNum - 1] = false;
        System.out.println("Seat " + seatNum + " has been cancelled. Thank you.");
    }
}


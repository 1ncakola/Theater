import java.util.ArrayList;
import java.util.Scanner;

public class MovieTheater {
    private static final ArrayList<Integer> reservedSeats = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Reserve Seat\n2. Cancel Reservation\n3. View Reserved Seats\n4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> reserveSeat(scanner);
                case 2 -> cancelReservation(scanner);
                case 3 -> viewReservedSeats();
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void reserveSeat(Scanner scanner) {
        System.out.print("Enter seat number to reserve (1-50): ");
        int seat = scanner.nextInt();
        if (seat < 1 || seat > 50) {
            System.out.println("Invalid seat number. Try again.");
        } else if (reservedSeats.contains(seat)) {
            System.out.println("Seat is already reserved.");
        } else {
            reservedSeats.add(seat);
            System.out.println("Seat " + seat + " reserved successfully!");
        }
    }

    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter seat number to cancel (1-50): ");
        int seat = scanner.nextInt();
        if (reservedSeats.remove(Integer.valueOf(seat))) {
            System.out.println("Reservation for seat " + seat + " cancelled successfully!");
        } else {
            System.out.println("Seat " + seat + " is not reserved.");
        }
    }

    private static void viewReservedSeats() {
        if (reservedSeats.isEmpty()) {
            System.out.println("No seats are reserved.");
        } else {
            System.out.println("Reserved seats: " + reservedSeats);
        }
    }
}

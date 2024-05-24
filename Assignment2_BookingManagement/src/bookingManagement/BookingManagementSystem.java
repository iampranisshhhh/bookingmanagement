package bookingManagement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingManagementSystem {
	public static void main(String[] args) {
        BookingController controller = new BookingController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Update Booking");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        String userName = scanner.nextLine();
                        System.out.print("Enter number of tickets: ");
                        int numberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        controller.addBooking(userName, numberOfTickets);
                        break;
                    case 2:
                        controller.viewBookings();
                        break;
                    case 3:
                        System.out.print("Enter booking ID to cancel: ");
                        int bookingId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        controller.cancelBooking(bookingId);
                        break;
                    case 4:
                        System.out.print("Enter booking ID to update: ");
                        int updateBookingId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new number of tickets: ");
                        int newNumberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        controller.updateBooking(updateBookingId, newNumberOfTickets);
                        break;
                    case 5:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
package bookingManagement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookingManagementSystem {
	private static final String DATE_FORMAT = "yyyy-MM-dd";

    public static void main(String[] args) {
        BookingController controller = new BookingController();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Booking");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Update Booking");
            System.out.println("5. Check Availability");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        Event event = getEventDetails(scanner);
                        System.out.print("Enter your name: ");
                        String userName = scanner.nextLine();
                        System.out.print("Enter number of tickets: ");
                        int numberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        controller.addBooking(event, userName, numberOfTickets);
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
                        Event newEvent = getEventDetails(scanner);
                        System.out.print("Enter new number of tickets: ");
                        int newNumberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        controller.updateBooking(updateBookingId, newEvent, newNumberOfTickets);
                        break;
                    case 5:
                        Event eventToCheck = getEventDetails(scanner);
                        boolean isAvailable = controller.checkAvailability(eventToCheck);
                        System.out.println("Event availability: " + (isAvailable ? "Available" : "Not Available"));
                        break;
                    case 6:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }

    private static Event getEventDetails(Scanner scanner) throws ParseException {
        System.out.print("Enter event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (yyyy-MM-dd): ");
        String eventDateStr = scanner.nextLine();
        Date eventDate = new SimpleDateFormat(DATE_FORMAT).parse(eventDateStr);
        System.out.print("Enter event type: ");
        String eventType = scanner.nextLine();
        return new Event(eventId, eventName, eventDate, eventType);
    }
}
package ticketManagement;

import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        Admin admin = new Admin(bookingController);
        EventManagement eventManagement = new EventManagement();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Booking");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Update Booking");
            System.out.println("4. Admin");
            System.out.println("5. Event Management");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter your name: ");
                        String userName = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String userEmail = scanner.nextLine();
                        System.out.print("Enter number of tickets: ");
                        int numberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.println("Available Events:");
                        eventManagement.listEvents();
                        System.out.print("Enter Event ID to book: ");
                        int eventId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Event event = eventManagement.getEventById(eventId);
                        if (event != null) {
                            bookingController.addBooking(userName, userEmail, numberOfTickets, event);
                        } else {
                            System.out.println("Invalid Event ID.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter booking ID to cancel: ");
                        int bookingId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        bookingController.cancelBooking(bookingId);
                        break;
                    case 3:
                        System.out.print("Enter booking ID to update: ");
                        int updateBookingId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new number of tickets: ");
                        int newNumberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        bookingController.updateBooking(updateBookingId, newNumberOfTickets);
                        break;
                    case 4:
                        adminMenu(admin, scanner);
                        break;
                    case 5:
                        eventManagementMenu(eventManagement, scanner);
                        break;
                    case 6:
                        System.out.println("Exiting the program...");
                        running = false;
                        System.exit(0);
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

    private static void adminMenu(Admin admin, Scanner scanner) {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("Admin Menu:");
            System.out.println("1. View User Bookings");
            System.out.println("2. Back to Main Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (adminChoice) {
                case 1:
                    System.out.print("Enter user name to view bookings: ");
                    String userToView = scanner.nextLine();
                    admin.viewUserBookings(userToView);
                    break;
                case 2:
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void eventManagementMenu(EventManagement eventManagement, Scanner scanner) {
        boolean eventRunning = true;

        while (eventRunning) {
            System.out.println("Event Management Menu:");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. List Events");
            System.out.println("5. View Event Details");
            System.out.println("6. Generate Event Report");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            int eventChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (eventChoice) {
                case 1:
                    System.out.print("Enter Event ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Event Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Event Date (yyyy-mm-dd): ");
                    String dateStr = scanner.nextLine();
                    Date date = java.sql.Date.valueOf(dateStr);
                    System.out.print("Enter Event Venue: ");
                    String venue = scanner.nextLine();
                    System.out.print("Enter Event Type (Movie, Concert, Theatre Play): ");
                    String type = scanner.nextLine();
                    Event event = new Event(id, name, date, venue, type);
                    eventManagement.addEvent(event);
                    break;
                case 2:
                    System.out.print("Enter Event ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Event Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Event Date (yyyy-mm-dd): ");
                    String newDateStr = scanner.nextLine();
                    Date newDate = java.sql.Date.valueOf(newDateStr);
                    System.out.print("Enter New Event Venue: ");
                    String newVenue = scanner.nextLine();
                    System.out.print("Enter New Event Type (Movie, Concert, Theatre Play): ");
                    String newType = scanner.nextLine();
                    eventManagement.updateEvent(updateId, newName, newDate, newVenue, newType);
                    break;
                case 3:
                    System.out.print("Enter Event ID to delete: ");
                    int deleteId = scanner.nextInt();
                    eventManagement.deleteEvent(deleteId);
                    break;
                case 4:
                    eventManagement.listEvents();
                    break;
                case 5:
                    System.out.print("Enter Event ID to view details: ");
                    int viewId = scanner.nextInt();
                    eventManagement.viewEventDetails(viewId);
                    break;
                case 6:
                    eventManagement.generateEventReport();
                    break;
                case 7:
                    eventRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
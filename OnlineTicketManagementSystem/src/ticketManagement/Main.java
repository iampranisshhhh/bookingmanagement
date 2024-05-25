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
            System.out.println("1. Current Events");
            System.out.println("2. Bookings");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        currentEventsMenu(eventManagement, scanner);
                        break;
                    case 2:
                        bookingsMenu(bookingController, eventManagement, scanner);
                        break;
                    case 3:
                        adminMenu(admin, eventManagement, scanner);
                        break;
                    case 4:
                        System.out.println("Exiting the system...");
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

    private static void currentEventsMenu(EventManagement eventManagement, Scanner scanner) {
        boolean eventsRunning = true;
        while (eventsRunning) {
            System.out.println("Current Events Menu:");
            System.out.println("1. Movies");
            System.out.println("2. Concerts");
            System.out.println("3. Theatre Plays");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int eventsChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (eventsChoice) {
                case 1:
                    System.out.println("Available Movies:");
                    eventManagement.listEventsByType("Movie");
                    break;
                case 2:
                    System.out.println("Available Concerts:");
                    eventManagement.listEventsByType("Concert");
                    break;
                case 3:
                    System.out.println("Available Theatre Plays:");
                    eventManagement.listEventsByType("Theatre Play");
                    break;
                case 4:
                    eventsRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void bookingsMenu(BookingController bookingController, EventManagement eventManagement, Scanner scanner) {
        boolean bookingsRunning = true;
        while (bookingsRunning) {
            System.out.println("Bookings Menu:");
            System.out.println("1. Add Booking");
            System.out.println("2. Update Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            int bookingsChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (bookingsChoice) {
                case 1:
                    System.out.println("Select Event Type:");
                    System.out.println("1. Movie");
                    System.out.println("2. Concert");
                    System.out.println("3. Theatre Play");
                    System.out.print("Choose an event type: ");
                    int eventTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String eventType = "";
                    switch (eventTypeChoice) {
                        case 1:
                            eventType = "Movie";
                            break;
                        case 2:
                            eventType = "Concert";
                            break;
                        case 3:
                            eventType = "Theatre Play";
                            break;
                        default:
                            System.out.println("Invalid event type. Please try again.");
                            continue;
                    }
                    System.out.println("Available " + eventType + " Events:");
                    eventManagement.listEventsByType(eventType);
                    System.out.print("Enter Event ID to book: ");
                    String eventId = scanner.nextLine();
                    Event event = eventManagement.getEventById(eventId);
                    if (event != null) {
                        System.out.print("Enter your name: ");
                        String userName = scanner.nextLine();
                        System.out.print("Enter your email: ");
                        String userEmail = scanner.nextLine();
                        System.out.print("Enter number of tickets: ");
                        int numberOfTickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        bookingController.addBooking(userName, userEmail, numberOfTickets, event);
                    } else {
                        System.out.println("Invalid Event ID.");
                    }
                    break;
                case 2:
                    System.out.print("Enter booking ID to update: ");
                    int updateBookingId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new number of tickets: ");
                    int newNumberOfTickets = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bookingController.updateBooking(updateBookingId, newNumberOfTickets);
                    break;
                case 3:
                    System.out.print("Enter booking ID to cancel: ");
                    int bookingId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    bookingController.cancelBooking(bookingId);
                    break;
                case 4:
                    bookingsRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminMenu(Admin admin, EventManagement eventManagement, Scanner scanner) {
        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("Admin Menu:");
            System.out.println("1. Event Management");
            System.out.println("2. Booking Details");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (adminChoice) {
                case 1:
                    eventManagementMenu(eventManagement, scanner);
                    break;
                case 2:
                    System.out.print("Enter user name to view bookings: ");
                    String userToView = scanner.nextLine();
                    admin.viewUserBookings(userToView);
                    break;
                case 3:
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
            System.out.println("7. Back to Admin Menu");
            System.out.print("Choose an option: ");
            int eventChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (eventChoice) {
                case 1:
                    System.out.println("Select Event Type:");
                    System.out.println("1. Movie");
                    System.out.println("2. Concert");
                    System.out.println("3. Theatre Play");
                    System.out.print("Choose an event type: ");
                    int eventTypeChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    String eventType = "";
                    switch (eventTypeChoice) {
                        case 1:
                            eventType = "Movie";
                            break;
                        case 2:
                            eventType = "Concert";
                            break;
                        case 3:
                            eventType = "Theatre Play";
                            break;
                        default:
                            System.out.println("Invalid event type. Please try again.");
                            continue;
                    }
                    System.out.print("Enter Event ID: ");
                    String eventId = scanner.nextLine();
                    System.out.print("Enter Event Name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter Event Date (yyyy-mm-dd): ");
                    String dateStr = scanner.nextLine();
                    Date eventDate = java.sql.Date.valueOf(dateStr);
                    System.out.print("Enter Event Venue: ");
                    String eventVenue = scanner.nextLine();
                    System.out.print("Enter Event Time: ");
                    String eventTime = scanner.nextLine();
                    System.out.print("Enter Hall Number: ");
                    String hallNumber = scanner.nextLine();
                    Event event = new Event(eventId, eventName, eventDate, eventVenue, eventType, eventTime, hallNumber);
                    eventManagement.addEvent(event);
                    break;
                case 2:
                    System.out.print("Enter Event ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Event Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Event Date (yyyy-mm-dd): ");
                    String newDateStr = scanner.nextLine();
                    Date newDate = java.sql.Date.valueOf(newDateStr);
                    System.out.print("Enter New Event Venue: ");
                    String newVenue = scanner.nextLine();
                    System.out.print("Enter New Event Type (Movie, Concert, Theatre Play): ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter New Event Time: ");
                    String newTime = scanner.nextLine();
                    System.out.print("Enter New Hall Number: ");
                    String newHallNumber = scanner.nextLine();
                    eventManagement.updateEvent(updateId, newName, newDate, newVenue, newType, newTime, newHallNumber);
                    break;
                case 3:
                    System.out.print("Enter Event ID to delete: ");
                    String deleteId = scanner.nextLine();
                    eventManagement.deleteEvent(deleteId);
                    break;
                case 4:
                    eventManagement.listEvents();
                    break;
                case 5:
                    System.out.print("Enter Event ID to view details: ");
                    String viewId = scanner.nextLine();
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
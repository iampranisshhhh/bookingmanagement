package bookingManagement;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Online Ticket Booking System ---");
            System.out.println("1. View Events");
            System.out.println("2. Book Ticket");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewEvents(bookingManager, scanner);
                    break;
                case 2:
                    bookTicket(bookingManager, scanner);
                    break;
                case 3:
                    adminLogin(scanner, bookingManager);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void viewEvents(BookingManager bookingManager, Scanner scanner) {
        System.out.println("Select Event Type:");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Theatre Play");
        System.out.print("Enter your choice: ");
        int eventTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EventType eventType;
        switch (eventTypeChoice) {
            case 1:
                eventType = EventType.MOVIE;
                break;
            case 2:
                eventType = EventType.CONCERT;
                break;
            case 3:
                eventType = EventType.THEATRE_PLAY;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Movie.");
                eventType = EventType.MOVIE;
        }

        List<String> events = bookingManager.getEventsByType(eventType);
        System.out.println("Available " + eventType + "s:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i));
        }
    }

    private static void bookTicket(BookingManager bookingManager, Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        User user = bookingManager.createUser(name, email);

        System.out.println("Select Event Type:");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Theatre Play");
        System.out.print("Enter your choice: ");
        int eventTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EventType eventType;
        switch (eventTypeChoice) {
            case 1:
                eventType = EventType.MOVIE;
                break;
            case 2:
                eventType = EventType.CONCERT;
                break;
            case 3:
                eventType = EventType.THEATRE_PLAY;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Movie.");
                eventType = EventType.MOVIE;
        }

        List<String> events = bookingManager.getEventsByType(eventType);
        System.out.println("Available " + eventType + "s:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i));
        }
        System.out.print("Select an event: ");
        int eventChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (eventChoice < 1 || eventChoice > events.size()) {
            System.out.println("Invalid choice. Booking canceled.");
            return;
        }

        String eventName = events.get(eventChoice - 1);
        String dateTime = "";
        if (eventType == EventType.MOVIE) {
            System.out.println("Select Show Time:");
            System.out.println("1. 10 AM");
            System.out.println("2. 2 PM");
            System.out.println("3. 5 PM");
            System.out.print("Enter your choice: ");
            int timeChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (timeChoice) {
                case 1:
                    dateTime = "10 AM";
                    break;
                case 2:
                    dateTime = "2 PM";
                    break;
                case 3:
                    dateTime = "5 PM";
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to 10 AM.");
                    dateTime = "10 AM";
            }
        } else if (eventType == EventType.THEATRE_PLAY) {
            dateTime = "6 PM";
        } else if (eventType == EventType.CONCERT) {
            System.out.print("Enter the date of the concert (YYYY-MM-DD): ");
            dateTime = scanner.nextLine();
        }

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();
        bookingManager.addBooking(eventType, eventName, user, numberOfTickets, dateTime);
    }

    private static void adminLogin(Scanner scanner, BookingManager bookingManager) {
        System.out.print("Enter admin name: ");
        String adminName = scanner.nextLine();
        System.out.print("Enter admin email: ");
        String adminEmail = scanner.nextLine();
        Admin currentAdmin = bookingManager.createAdmin(adminName, adminEmail);
        System.out.println("Admin logged in: " + currentAdmin);
        adminMenu(scanner, bookingManager, currentAdmin);
    }

    private static void adminMenu(Scanner scanner, BookingManager bookingManager, Admin currentAdmin) {
        int adminChoice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View All Bookings");
            System.out.println("2. View User Bookings and Details");
            System.out.println("3. Add Event");
            System.out.println("4. Edit Event");
            System.out.println("5. Delete Event");
            System.out.println("6. Exit Admin Menu");
            System.out.print("Enter your choice: ");
            adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (adminChoice) {
                case 1:
                    bookingManager.viewBookings();
                    break;
                case 2:
                    viewUserBookingsAndDetails(scanner, bookingManager);
                    break;
                case 3:
                    addEvent(scanner, bookingManager);
                    break;
                case 4:
                    editEvent(scanner, bookingManager);
                    break;
                case 5:
                    deleteEvent(scanner, bookingManager);
                    break;
                case 6:
                    System.out.println("Exiting Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (adminChoice != 6);
    }

    private static void viewUserBookingsAndDetails(Scanner scanner, BookingManager bookingManager) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        User user = bookingManager.findUserById(userId);
        if (user != null) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
            bookingManager.viewUserBookings(user);
        } else {
            System.out.println("User ID not found.");
        }
    }

    private static void addEvent(Scanner scanner, BookingManager bookingManager) {
        System.out.println("Select Event Type:");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Theatre Play");
        System.out.print("Enter your choice: ");
        int eventTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EventType eventType;
        switch (eventTypeChoice) {
            case 1:
                eventType = EventType.MOVIE;
                break;
            case 2:
                eventType = EventType.CONCERT;
                break;
            case 3:
                eventType = EventType.THEATRE_PLAY;
                break;
            default:
                System.out.println("Invalid choice. Event not added.");
                return;
        }

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        bookingManager.addEvent(eventType, eventName);
    }

    private static void editEvent(Scanner scanner, BookingManager bookingManager) {
        System.out.println("Select Event Type:");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Theatre Play");
        System.out.print("Enter your choice: ");
        int eventTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EventType eventType;
        switch (eventTypeChoice) {
            case 1:
                eventType = EventType.MOVIE;
                break;
            case 2:
                eventType = EventType.CONCERT;
                break;
            case 3:
                eventType = EventType.THEATRE_PLAY;
                break;
            default:
                System.out.println("Invalid choice. Event not edited.");
                return;
        }

        System.out.print("Enter current event name: ");
        String oldEventName = scanner.nextLine();
        System.out.print("Enter new event name: ");
        String newEventName = scanner.nextLine();
        bookingManager.editEvent(eventType, oldEventName, newEventName);
    }

    private static void deleteEvent(Scanner scanner, BookingManager bookingManager) {
        System.out.println("Select Event Type:");
        System.out.println("1. Movie");
        System.out.println("2. Concert");
        System.out.println("3. Theatre Play");
        System.out.print("Enter your choice: ");
        int eventTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EventType eventType;
        switch (eventTypeChoice) {
            case 1:
                eventType = EventType.MOVIE;
                break;
            case 2:
                eventType = EventType.CONCERT;
                break;
            case 3:
                eventType = EventType.THEATRE_PLAY;
                break;
            default:
                System.out.println("Invalid choice. Event not deleted.");
                return;
        }

        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        bookingManager.deleteEvent(eventType, eventName);
    }
}
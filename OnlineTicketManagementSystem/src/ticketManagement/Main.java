package ticketManagement;

import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Main {
	private BookingController bookingController = new BookingController();
    private Admin admin = new Admin(bookingController);
    private EventManagement eventManagement = new EventManagement();
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public static void main(String[] args) {
        Main main = new Main();
        main.addPredefinedEvents(main.eventManagement);
        main.run();
    }

    private void run() {
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
                        System.out.println("Exiting the program...");
                        running = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private void addPredefinedEvents(EventManagement eventManagement) {
        try {
            // Movies
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "A Space Odyssey", new Date(), "Cinema Hall 1", "Movie", "9 AM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "The Godfather", new Date(), "Cinema Hall 2", "Movie", "2 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "The Shawshank Redemption", new Date(), "Cinema Hall 3", "Movie", "5 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "The Dark Knight", new Date(), "Cinema Hall 4", "Movie", "9 AM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Goodfellas", new Date(), "Cinema Hall 5", "Movie", "2 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Forrest Gump", new Date(), "Cinema Hall 6", "Movie", "5 PM"));

            // Concerts
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "The Eras", new Date(), "Concert Hall 1", "Concert", "7 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Farewell Yellow Brick Road", new Date(), "Concert Hall 2", "Concert", "8 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Music of the Spheres", new Date(), "Concert Hall 3", "Concert", "9 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Michael Jackson", new Date(), "Concert Hall 4", "Concert", "7 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Metallica's", new Date(), "Concert Hall 5", "Concert", "8 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Radiohead", new Date(), "Concert Hall 6", "Concert", "9 PM"));

            // Theatre Plays
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Hamlet", new Date(), "Theatre 1", "Theatre Play", "5 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "A Raisin in the Sun", new Date(), "Theatre 2", "Theatre Play", "5 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "The Importance of Being Earnest", new Date(), "Theatre 3", "Theatre Play", "5 PM"));
            eventManagement.addEvent(new Event(UUID.randomUUID().toString(), "Long Day's Journey Into Night", new Date(), "Theatre 4", "Theatre Play", "5 PM"));
        } catch (Exception e) {
            System.out.println("Error adding predefined events: " + e.getMessage());
        }
    }

    private void currentEventsMenu(EventManagement eventManagement, Scanner scanner) {
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

            try {
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void bookingsMenu(BookingController bookingController, EventManagement eventManagement, Scanner scanner) {
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

            try {
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
                        System.out.print("Enter Event Name to book: ");
                        String eventName = scanner.nextLine();

                        Event event = eventManagement.getEventByName(eventName);
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
                            System.out.println("Invalid Event Name.");
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void adminMenu(Admin admin, EventManagement eventManagement, Scanner scanner) {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("Admin Menu:");
            System.out.println("1. Event Management");
            System.out.println("2. Booking Details");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (adminChoice) {
                    case 1:
                        eventManagementMenu(eventManagement, scanner);
                        break;
                    case 2:
                        admin.viewUserBookings(null);
                        break;
                    case 3:
                        adminRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void eventManagementMenu(EventManagement eventManagement, Scanner scanner) {
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

            try {
                switch (eventChoice) {
                    case 1:
                        System.out.print("Enter Event Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Event Date (yyyy-mm-dd): ");
                        String dateStr = scanner.nextLine();
                        Date date = java.sql.Date.valueOf(dateStr);
                        System.out.print("Enter Event Venue: ");
                        String venue = scanner.nextLine();
                        System.out.print("Enter Event Type (Movie, Concert, Theatre Play): ");
                        String type = scanner.nextLine();
                        System.out.print("Enter Event Time: ");
                        String time = scanner.nextLine();
                        Event event = new Event(UUID.randomUUID().toString(), name, date, venue, type, time);
                        eventManagement.addEvent(event);
                        System.out.println("Event added successfully.");
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
                        eventManagement.updateEvent(updateId, newName, newDate, newVenue, newType, newTime);
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
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
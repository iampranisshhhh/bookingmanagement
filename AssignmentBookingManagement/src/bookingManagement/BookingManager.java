package bookingManagement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookingManager {
	 private List<Booking> bookings;
	    private Map<String, User> users;
	    private Map<String, Admin> admins;
	    private List<String> movies;
	    private List<String> concerts;
	    private List<String> theatrePlays;
	    private int userCounter;

	    public BookingManager() {
	        bookings = new ArrayList<>();
	        users = new HashMap<>();
	        admins = new HashMap<>();
	        movies = new ArrayList<>(List.of("The Godfather", "The Shawshank Redemption", "Forrest Gump", "The Avengers", "Inception"));
	        concerts = new ArrayList<>(List.of("Metallica", "The Iconic Queen", "BTS", "Taylor Swift", "Great White", "Nepathya"));
	        theatrePlays = new ArrayList<>(List.of("A Raisin in the Sun", "Machine", "Angels in America", "The Homecoming", "Candida", "God of Carnage"));
	        userCounter = 1;
	    }

	    public List<String> getEventsByType(EventType eventType) {
	        switch (eventType) {
	            case MOVIE:
	                return movies;
	            case CONCERT:
	                return concerts;
	            case THEATRE_PLAY:
	                return theatrePlays;
	            default:
	                return new ArrayList<>();
	        }
	    }

	    public void addBooking(EventType eventType, String eventName, User user, int numberOfTickets, String dateTime) {
	        Booking booking = new Booking(eventType, eventName, user, numberOfTickets, dateTime);
	        bookings.add(booking);
	        user.addBooking(booking);
	        System.out.println("Booking successful! " + booking);
	        sendConfirmationEmail(user, booking);
	    }

	    public void viewBookings() {
	        if (bookings.isEmpty()) {
	            System.out.println("No bookings found.");
	        } else {
	            for (Booking booking : bookings) {
	                System.out.println(booking);
	            }
	        }
	    }

	    public void cancelBooking(String bookingId) {
	        Booking bookingToRemove = null;
	        for (Booking booking : bookings) {
	            if (booking.getBookingId().equals(bookingId)) {
	                bookingToRemove = booking;
	                break;
	            }
	        }
	        if (bookingToRemove != null) {
	            bookings.remove(bookingToRemove);
	            bookingToRemove.getUser().getBookings().remove(bookingToRemove);
	            System.out.println("Booking canceled: " + bookingToRemove);
	        } else {
	            System.out.println("Booking ID not found.");
	        }
	    }

	    public User createUser(String name, String email) {
	        String userId = generateUserId(name);
	        User user = new User(userId, name, email);
	        users.put(userId, user);
	        return user;
	    }

	    public User findUserById(String userId) {
	        return users.get(userId);
	    }

	    public void updateUser(User user, String newName, String newEmail) {
	        user.setName(newName);
	        user.setEmail(newEmail);
	        System.out.println("User updated: " + user);
	    }

	    public void viewUserBookings(User user) {
	        List<Booking> userBookings = user.getBookings();
	        if (userBookings.isEmpty()) {
	            System.out.println("No bookings found for user: " + user.getName());
	        } else {
	            for (Booking booking : userBookings) {
	                System.out.println(booking);
	            }
	        }
	    }

	    public Admin createAdmin(String name, String email) {
	        Admin admin = new Admin(name, email);
	        admins.put(admin.getId(), admin);
	        return admin;
	    }

	    public Admin findAdminById(String adminId) {
	        return admins.get(adminId);
	    }

	    public void addEvent(EventType eventType, String eventName) {
	        switch (eventType) {
	            case MOVIE:
	                movies.add(eventName);
	                break;
	            case CONCERT:
	                concerts.add(eventName);
	                break;
	            case THEATRE_PLAY:
	                theatrePlays.add(eventName);
	                break;
	        }
	        System.out.println("Event added: " + eventName);
	    }

	    public void editEvent(EventType eventType, String oldEventName, String newEventName) {
	        List<String> events = getEventsByType(eventType);
	        int index = events.indexOf(oldEventName);
	        if (index != -1) {
	            events.set(index, newEventName);
	            System.out.println("Event updated: " + oldEventName + " to " + newEventName);
	        } else {
	            System.out.println("Event not found: " + oldEventName);
	        }
	    }

	    public void deleteEvent(EventType eventType, String eventName) {
	        List<String> events = getEventsByType(eventType);
	        if (events.remove(eventName)) {
	            System.out.println("Event deleted: " + eventName);
	        } else {
	            System.out.println("Event not found: " + eventName);
	        }
	    }

	    private String generateUserId(String name) {
	        String prefix = name.length() >= 3 ? name.substring(0, 3).toUpperCase() : name.toUpperCase();
	        return String.format("%s%03d", prefix, userCounter++);
	    }

	    private void sendConfirmationEmail(User user, Booking booking) {
	        // Simulate sending an email
	        System.out.println("Sending confirmation email to " + user.getEmail());
	        System.out.println("Dear " + user.getName() + ",\nYour booking for " + booking.getEventName() + " on " + booking.getDateTime() + " has been confirmed.\nBooking ID: " + booking.getBookingId() + "\nThank you!");
	    }
	}
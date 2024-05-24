package bookingManagement;
import java.util.HashMap;
import java.util.Map;

public class BookingController {
	private final Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    public synchronized void addBooking(Event event, String userName, int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
        Booking booking = new Booking(bookingCounter++, event, userName, numberOfTickets);
        bookings.put(booking.getBookingId(), booking);
        System.out.println("Booking added successfully!");
        sendConfirmationEmail(booking);
    }

    public synchronized void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookings.values()) {
                System.out.println("Booking ID: " + booking.getBookingId() +
                                   ", Event: " + booking.getEvent().getEventName() +
                                   ", User: " + booking.getUserName() +
                                   ", Tickets: " + booking.getNumberOfTickets());
            }
        }
    }

    public synchronized void cancelBooking(int bookingId) {
        if (bookings.remove(bookingId) != null) {
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    public synchronized void updateBooking(int bookingId, Event newEvent, int newNumberOfTickets) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.setEvent(newEvent);
            booking.setNumberOfTickets(newNumberOfTickets);
            System.out.println("Booking updated successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    public boolean checkAvailability(Event event) {
        // Implement logic to check availability based on event details
        // For simplicity, let's assume all events are available
        return true;
    }

    private void sendConfirmationEmail(Booking booking) {
        // Implement email sending logic here
        System.out.println("Confirmation email sent to " + booking.getUserName() + " for booking ID " + booking.getBookingId());
    }

}
package bookingManagement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;






public class BookingController implements BookingOperations {
	private final Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    @Override
    public synchronized void addBooking(String userName, int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
        Booking booking = new Booking(bookingCounter++, userName, numberOfTickets);
        bookings.put(booking.getBookingId(), booking);
        System.out.println("Booking added successfully with ID: " + booking.getBookingId());
        sendConfirmationEmail(booking);
    }

    @Override
    public synchronized void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            for (Booking booking : bookings.values()) {
                System.out.println("Booking ID: " + booking.getBookingId() +
                                   ", User: " + booking.getUserName() +
                                   ", Tickets: " + booking.getNumberOfTickets());
            }
        }
    }

    @Override
    public synchronized void cancelBooking(int bookingId) {
        if (bookings.remove(bookingId) != null) {
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    @Override
    public synchronized void updateBooking(int bookingId, int newNumberOfTickets) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.setNumberOfTickets(newNumberOfTickets);
            System.out.println("Booking updated successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    private void sendConfirmationEmail(Booking booking) {
        // Implement email sending logic here
        System.out.println("Confirmation email sent to " + booking.getUserName() + " for booking ID " + booking.getBookingId());
    }
}
    
    		
    		
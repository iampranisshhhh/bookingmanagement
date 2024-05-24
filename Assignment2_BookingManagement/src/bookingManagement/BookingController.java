package bookingManagement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;






public class BookingController {
	private final Map<Integer, Booking> bookings = new HashMap<>();
    private int bookingCounter = 1;

    public synchronized void addBooking(String userName, int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingCounter++, userName, numberOfTickets);
        bookings.put(booking.getBookingId(), booking);
        System.out.println("Booking added successfully with ID: " + bookingId);
        sendConfirmationEmail(booking);
    }

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

    public synchronized void cancelBooking(int bookingId) {
        if (bookings.remove(bookingId) != null) {
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

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

    private String generateBookingId() {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomString = getRandomAlphanumericString(5);
        return timestamp + randomString;
    }

    private String getRandomAlphanumericString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
}
package ticketManagement;

import java.util.HashMap;
import java.util.Map;

public class BookingController implements BookingOperations {
	 private final Map<Integer, Booking> bookings = new HashMap<>();
	    private int bookingCounter = 1;

	    public synchronized void addBooking(String userName, String userEmail, int numberOfTickets) {
	        if (numberOfTickets <= 0) {
	            throw new IllegalArgumentException("Number of tickets must be positive.");
	        }
	        Booking booking = new Booking(bookingCounter++, userName, userEmail, numberOfTickets);
	        bookings.put(booking.getBookingId(), booking);
	        System.out.println("Booking added successfully with ID: " + booking.getBookingId());
	        sendConfirmationEmail(booking);
	    }

	    public synchronized void viewBookings() {
	        if (bookings.isEmpty()) {
	            System.out.println("No bookings available.");
	        } else {
	            for (Booking booking : bookings.values()) {
	                System.out.println("Booking ID: " + booking.getBookingId() +
	                                   ", User: " + booking.getUserName() +
	                                   ", Email: " + booking.getUserEmail() +
	                                   ", Tickets: " + booking.getNumberOfTickets());
	            }
	        }
	    }

	    public synchronized void viewBookingsByUser(String userName) {
	        boolean found = false;
	        for (Booking booking : bookings.values()) {
	            if (booking.getUserName().equals(userName)) {
	                System.out.println("Booking ID: " + booking.getBookingId() +
	                                   ", User: " + booking.getUserName() +
	                                   ", Email: " + booking.getUserEmail() +
	                                   ", Tickets: " + booking.getNumberOfTickets());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No bookings found for user: " + userName);
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
	        String confirmationMessage = "Confirmation email sent to " + booking.getUserEmail() + " for booking ID " + booking.getBookingId();
	        System.out.println(confirmationMessage);
	    }

		public void viewBookingsByUser1(String userName) {
		
			
		}

		public void viewBookingsByUser11(String userName) {
			// TODO Auto-generated method stub
			
		}
	}



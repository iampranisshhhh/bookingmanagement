package ticketManagement;

public interface BookingOperations {
	void addBooking(String userName, String userEmail, int numberOfTickets, Event event);
    void viewBookings();
    void cancelBooking(int bookingId);
    void updateBooking(int bookingId, int newNumberOfTickets);
}
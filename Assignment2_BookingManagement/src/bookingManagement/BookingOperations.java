package bookingManagement;

public interface BookingOperations {
	void addBooking(String userName, String userEmail, int numberOfTickets);
    void viewBookings();
    void cancelBooking(int bookingId);
    void updateBooking(int bookingId, int newNumberOfTickets);
}
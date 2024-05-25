package bookingManagement;

public class Booking {
	private int bookingId;
    private String userName;
    private String userEmail;
    private int numberOfTickets;

    public Booking(int bookingId, String userName, String userEmail, int numberOfTickets) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public int getNumberOfTickets() { return numberOfTickets; }

    // Setters with validation
    public void setNumberOfTickets(int numberOfTickets) {
        if (numberOfTickets > 0) {
            this.numberOfTickets = numberOfTickets;
        } else {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
    }
}

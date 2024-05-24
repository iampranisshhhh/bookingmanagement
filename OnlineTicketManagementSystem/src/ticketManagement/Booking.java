package ticketManagement;


public class Booking {
	private int bookingId;
    private String userName;
    private String userEmail;
    private int numberOfTickets;
    private Event event;

    public Booking(int bookingId, String userName, String userEmail, int numberOfTickets, Event event) {
        this.bookingId = bookingId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.numberOfTickets = numberOfTickets;
        this.event = event;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public String getUserName() { return userName; }
    public String getUserEmail() { return userEmail; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public Event getEvent() { return event; }

    // Setters with validation
    public void setNumberOfTickets(int numberOfTickets) {
        if (numberOfTickets > 0) {
            this.numberOfTickets = numberOfTickets;
        } else {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
    }
}
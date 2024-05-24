package bookingManagement;

public class Booking {
	private int bookingId;
    private Event event;
    private String userName;
    private int numberOfTickets;

    public Booking(int bookingId, Event event, String userName, int numberOfTickets) {
        this.bookingId = bookingId;
        this.event = event;
        this.userName = userName;
        this.numberOfTickets = numberOfTickets;
    }

    // Getters
    public int getBookingId() { return bookingId; }
    public Event getEvent() { return event; }
    public String getUserName() { return userName; }
    public int getNumberOfTickets() { return numberOfTickets; }

    // Setters with validation
    public void setNumberOfTickets(int numberOfTickets) {
        if (numberOfTickets > 0) {
            this.numberOfTickets = numberOfTickets;
        } else {
            throw new IllegalArgumentException("Number of tickets must be positive.");
        }
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
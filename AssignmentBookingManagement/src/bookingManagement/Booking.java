package bookingManagement;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Booking {
	private static final AtomicInteger counter = new AtomicInteger(1);
    private String bookingId;
    private EventType eventType;
    private String eventName;
    private User user;
    private int numberOfTickets;
    private String dateTime;

    public Booking(EventType eventType, String eventName, User user, int numberOfTickets, String dateTime) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.user = user;
        this.numberOfTickets = numberOfTickets;
        this.dateTime = dateTime;
        this.bookingId = generateBookingId(eventName);
    }

    private String generateBookingId(String eventName) {
        String prefix = eventName.substring(0, Math.min(eventName.length(), 3)).toUpperCase();
        int count = counter.getAndIncrement();
        return prefix + String.format("%03d", count);
    }

    public String getBookingId() {
        return bookingId;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public User getUser() {
        return user;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Event Type: " + eventType + ", Event: " + eventName + ", User: " + user.getName() + ", Tickets: " + numberOfTickets + ", DateTime: " + dateTime;
    }
}
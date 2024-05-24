package bookingManagement;
import java.util.Date;

public class Event {
	private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventType; // e.g., Movie, Concert, Theatre

    public Event(int eventId, String eventName, Date eventDate, String eventType) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
    }

    // Getters
    public int getEventId() { return eventId; }
    public String getEventName() { return eventName; }
    public Date getEventDate() { return eventDate; }
    public String getEventType() { return eventType; }
}
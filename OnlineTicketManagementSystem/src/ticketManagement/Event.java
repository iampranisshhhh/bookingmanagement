package ticketManagement;

import java.util.Date;

public class Event {
	private String eventId;
    private String eventName;
    private Date eventDate;
    private String eventVenue;
    private String eventType;
    private String eventTime;

    public Event(String eventId, String eventName, Date eventDate, String eventVenue, String eventType, String eventTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.eventType = eventType;
        this.eventTime = eventTime;
    }

    // Getters and Setters
    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }
    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }
    public Date getEventDate() { return eventDate; }
    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }
    public String getEventVenue() { return eventVenue; }
    public void setEventVenue(String eventVenue) { this.eventVenue = eventVenue; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getEventTime() { return eventTime; }
    public void setEventTime(String eventTime) { this.eventTime = eventTime; }

    @Override
    public String toString() {
        return "Event Name: " + eventName;
    }
}
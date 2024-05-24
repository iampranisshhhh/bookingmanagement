package ticketManagement;

import java.util.Date;

public class Event {
	private int eventId;
    private String eventName;
    private Date eventDate;
    private String eventVenue;

    public Event(int eventId, String eventName, Date eventDate, String eventVenue) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
    }

    // Getters and Setters
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Venue: " + eventVenue;
    }
}



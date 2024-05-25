package ticketManagement;

import java.util.Date;

public class Event {
	private String eventId;
    private String eventName;
    private Date eventDate;
    private String eventVenue;
    private String eventType;  // Movie, Concert, Theatre play
    private String eventTime;
    private String hallNumber;

    public Event(String eventId, String eventName, Date eventDate, String eventVenue, String eventType, String eventTime, String hallNumber) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventVenue = eventVenue;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.hallNumber = hallNumber;
    }

    public Event(int id, String name, Date date, String venue, String type) {
		// TODO Auto-generated constructor stub
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
    public String getHallNumber() { return hallNumber; }
    public void setHallNumber(String hallNumber) { this.hallNumber = hallNumber; }

    @Override
    public String toString() {
        return "Event Name: " + eventName + ", Type: " + eventType + ", Date: " + eventDate + ", Venue: " + eventVenue + ", Time: " + eventTime + ", Hall: " + hallNumber;
    }
}
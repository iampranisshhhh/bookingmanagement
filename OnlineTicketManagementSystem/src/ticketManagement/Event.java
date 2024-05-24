package ticketManagement;

import java.util.Date;

public class Event {
	 private int eventId;
	    private String eventName;
	    private Date eventDate;
	    private String eventVenue;
	    private String eventType; // Added eventType

	    public Event(int eventId, String eventName, Date eventDate, String eventVenue, String eventType) {
	        this.eventId = eventId;
	        this.eventName = eventName;
	        this.eventDate = eventDate;
	        this.eventVenue = eventVenue;
	        this.eventType = eventType;
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

	    public String getEventType() {
	        return eventType;
	    }

	    public void setEventType(String eventType) {
	        this.eventType = eventType;
	    }

	    @Override
	    public String toString() {
	        return "Event ID: " + eventId + ", Name: " + eventName + ", Date: " + eventDate + ", Venue: " + eventVenue + ", Type: " + eventType;
	    }
	}
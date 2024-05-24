package ticketManagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventManagement implements EventOperations {
	private List<Event> events;

    public EventManagement() {
        events = new ArrayList<>();
    }

    @Override
    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added successfully.");
    }

    @Override
    public void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                event.setEventName(newName);
                event.setEventDate(newDate);
                event.setEventVenue(newVenue);
                event.setEventType(newType);
                System.out.println("Event updated successfully.");
                return;
            }
        }
        System.out.println("Event not found.");
    }

    @Override
    public void deleteEvent(int eventId) {
        events.removeIf(event -> event.getEventId() == eventId);
        System.out.println("Event deleted successfully.");
    }

    @Override
    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    @Override
    public void listEventsByType(String eventType) {
        boolean found = false;
        for (Event event : events) {
            if (event.getEventType().equalsIgnoreCase(eventType)) {
                System.out.println(event);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events available for the selected type.");
        }
    }

    @Override
    public void viewEventDetails(int eventId) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                System.out.println(event);
                return;
            }
        }
        System.out.println("Event not found.");
    }

    @Override
    public void generateEventReport() {
        if (events.isEmpty()) {
            System.out.println("No events available to generate a report.");
        } else {
            System.out.println("Event Report:");
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    public Event getEventById(int eventId) {
        for (Event event : events) {
            if (event.getEventId() == eventId) {
                return event;
            }
        }
        return null;
    }
}
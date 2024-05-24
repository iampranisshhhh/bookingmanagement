package ticketManagement;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventManagement implements EventOperations {
	private final List<Event> events = new ArrayList<>();

    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public void updateEvent(String eventId, String newName, Date newDate, String newVenue, String newType, String newTime) {
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                event.setEventName(newName);
                event.setEventDate(newDate);
                event.setEventVenue(newVenue);
                event.setEventType(newType);
                event.setEventTime(newTime);
                return;
            }
        }
        System.out.println("Event not found.");
    }

    @Override
    public void deleteEvent(String eventId) {
        events.removeIf(event -> event.getEventId().equals(eventId));
    }

    @Override
    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            events.forEach(event -> System.out.println(event.getEventName()));
        }
    }

    @Override
    public void listEventsByType(String eventType) {
        boolean found = false;
        for (Event event : events) {
            if (event.getEventType().equalsIgnoreCase(eventType)) {
                System.out.println(event.getEventName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No events available for the selected type.");
        }
    }

    @Override
    public void viewEventDetails(String eventId) {
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
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
            events.forEach(System.out::println);
        }
    }

    public Event getEventById(String eventId) {
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                return event;
            }
        }
        return null;
    }

    public Event getEventByName(String eventName) {
        for (Event event : events) {
            if (event.getEventName().equalsIgnoreCase(eventName)) {
                return event;
            }
        }
        return null;
    }

	@Override
	public void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewEventDetails(int eventId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType,
			String newTime) {
		// TODO Auto-generated method stub
		
	}
}
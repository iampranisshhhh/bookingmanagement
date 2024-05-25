package ticketManagement;

import java.util.Date;

public interface EventOperations {
	void addEvent(Event event);
    void updateEvent(String eventId, String newName, Date newDate, String newVenue, String newType, String newTime);
    void deleteEvent(String eventId);
    void listEvents();
    void listEventsByType(String eventType);
    void viewEventDetails(String eventId);
    void generateEventReport();
	void updateEvent(String eventId, String newName, Date newDate, String newVenue, String newType, String newTime,
			String newHallNumber);
	void viewEventDetails(int viewId);
	void deleteEvent(int deleteId);
	void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType);
	void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType, String newTime);
}
package ticketManagement;

import java.util.Date;

public interface EventOperations {
	void addEvent(Event event);
    void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType);
    void deleteEvent(int eventId);
    void listEvents();
    void listEventsByType(String eventType);
    void viewEventDetails(int eventId);
    void generateEventReport();
	void updateEvent(int eventId, String newName, Date newDate, String newVenue, String newType, String newTime);
	void updateEvent(String updateId, String newName, Date newDate, String newVenue, String newType, String newTime);
	void deleteEvent(String eventId);
	void viewEventDetails(String eventId);
}
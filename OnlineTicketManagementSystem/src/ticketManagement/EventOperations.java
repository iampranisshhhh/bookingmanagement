package ticketManagement;

import java.util.Date;

public interface EventOperations {
	void addEvent(Event event);
    void updateEvent(int eventId, String newName, Date newDate, String newVenue);
    void deleteEvent(int eventId);
    void listEvents();
    void viewEventDetails(int eventId);
    void generateEventReport();
}
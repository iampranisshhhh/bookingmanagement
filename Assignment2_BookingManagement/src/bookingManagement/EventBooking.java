package bookingManagement;

public class EventBooking extends Booking {
	private String eventName;

    public EventBooking(int bookingId, String userName, int numberOfTickets, String eventName) {
        super(bookingId, userName, numberOfTickets);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}

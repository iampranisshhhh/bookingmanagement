package bookingManagement;
import java.util.List;

public class UserWithBookings {
	private User user;
    private List<Booking> bookings;

    public UserWithBookings(User user, List<Booking> bookings) {
        this.user = user;
        this.bookings = bookings;
    }

    public User getUser() {
        return user;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}



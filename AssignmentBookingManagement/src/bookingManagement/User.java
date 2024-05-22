package bookingManagement;
import java.util.ArrayList;
import java.util.List;

public class User {
	private String id;
    private String name;
    private String email;
    private List<Booking> bookings;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public String toString() {
        return "User ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}

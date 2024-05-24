package ticketManagement;

public class Admin implements AdminOperations {
    private BookingController bookingController;

    public Admin(BookingController bookingController) {
        this.bookingController = bookingController;
    }

    public void viewUserBookings(String userName) {
        bookingController.viewBookingsByUser1(userName);
    }
}
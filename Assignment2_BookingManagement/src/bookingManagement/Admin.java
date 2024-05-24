package bookingManagement;

import java.util.Scanner;

public class Admin implements AdminOperations {
	private BookingController bookingController;

    public Admin(BookingController bookingController) {
        this.bookingController = bookingController;
    }

    @Override
    public void viewUserBookings(String userName) {
        bookingController.viewBookingsByUser(userName);
    }
}
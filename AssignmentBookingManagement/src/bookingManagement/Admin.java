package bookingManagement;
import java.util.UUID;

public class Admin {
	private String id;
    private String name;
    private String email;

    public Admin(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Admin ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
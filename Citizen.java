
import java.util.*;

class Citizen extends User implements Locatable {
    private List<Contact> emergencyContacts;
    private Location location;

    public Citizen(String name, String phone, Location location) {
        super(name, phone);
        this.location = location;
        this.emergencyContacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        emergencyContacts.add(contact);
    }

    public List<Contact> getContacts() {
        return emergencyContacts;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}


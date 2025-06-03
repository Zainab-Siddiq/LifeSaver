
// import java.util.ArrayList;
// import java.util.List;

// public class Citizen extends User implements Locatable {
//     private List<Contact> emergencyContacts;
//     private Location location;

//     public Citizen(String name, String phoneNumber) {
//         super(name, phoneNumber);
//         this.emergencyContacts = new ArrayList<>();
//         this.location = new Location(0.0, 0.0); // Default location
//     }

//     public void addEmergencyContact(Contact contact) {
//         emergencyContacts.add(contact);
//     }

//     public List<Contact> getEmergencyContacts() {
//         return emergencyContacts;
//     }

//     public void reportAlert(Alert alert) {
//         Alert.sendAlert(this); // Overloaded method for sending alert
//     }

//     @Override
//     public Location getLocation() {
//         return location;
//     }

//     public void updateLocation(double latitude, double longitude) {
//         this.location.setLatitude(latitude);
//         this.location.setLongitude(longitude);
//     }

//     @Override
//     public void displayInfo() {
//         System.out.println("Citizen Name: " + getName());
//         System.out.println("Phone Number: " + getPhoneNumber());
//     }
// }

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


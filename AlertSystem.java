
// import java.util.List;

// public class AlertSystem {

//     public void sendAlerts(Citizen citizen, Alert alert) {
//         List<Contact> contacts = citizen.getEmergencyContacts();

//         if (contacts.isEmpty()) {
//             System.out.println("No emergency contacts found for " + citizen.getName());
//             return;
//         }

//         for (Contact contact : contacts) {
//             System.out.println("Sending alert to: " + contact);
//         }

//         Alert.sendAlert(citizen, citizen.getLocation());
//     }
// }

class AlertSystem {
    private Alert alert;

    public AlertSystem() {
        this.alert = new Alert();
    }

    public void triggerAlerts(Citizen citizen) {
        for (Contact contact : citizen.getContacts()) {
            alert.sendAlert(contact, citizen.getLocation());
        }
    }
}
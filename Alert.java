public class Alert {
    public void sendAlert(Contact contact) {
        System.out.println("Alert sent to " + contact.getName() + " at " + contact.getPhone());
    }

    public void sendAlert(Contact contact, Location location) {
        System.out.println("Alert sent to " + contact.getName() + " at " + contact.getPhone() +
                ". Last known location: " + location.getLatitude() + ", " + location.getLongitude());
    }
}


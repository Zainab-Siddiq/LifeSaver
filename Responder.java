// public class Responder extends User {

//     public Responder(String name, String phoneNumber) {
//         super(name, phoneNumber);
//     }

//     public void respondToAlert(Alert alert) {
//         System.out.println("Responder " + getName() + " is responding to the alert.");
//         // Simulation logic here
//     }

//     @Override
//     public void displayInfo() {
//         System.out.println("Responder Name: " + getName());
//         System.out.println("Phone Number: " + getPhoneNumber());
//     }
// }

class Responder extends User {
    private String department;

    public Responder(String name, String phone, String department) {
        super(name, phone);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

    
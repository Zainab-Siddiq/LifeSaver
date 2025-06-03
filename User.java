
// public abstract class User {
//     private String name;
//     private String phoneNumber;

//     public User(String name, String phoneNumber) {
//         this.name = name;
//         this.phoneNumber = phoneNumber;
//     }

//     // Getters
//     public String getName() {
//         return name;
//     }

//     public String getPhoneNumber() {
//         return phoneNumber;
//     }

//     // Setters
//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setPhoneNumber(String phoneNumber) {
//         this.phoneNumber = phoneNumber;
//     }

//     // Abstract method to be implemented by subclasses
//     public abstract void displayInfo();
// }
abstract class User {
    protected String name;
    protected String phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
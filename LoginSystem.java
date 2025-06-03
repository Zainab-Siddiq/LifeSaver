import java.io.*;
import java.util.*;

class LoginSystem {
    private static final String LOGIN_FILE = "login.txt";
    private static final String CONTACT_FILE = "contacts_";

    public boolean register(String username, String password, List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_FILE, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            saveContacts(username, contacts);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving user.");
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOGIN_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading login file.");
        }
        return false;
    }

    public void saveContacts(String username, List<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTACT_FILE + username + ".txt"))) {
            for (Contact c : contacts) {
                writer.write(c.getName() + "," + c.getPhone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts.");
        }
    }

    public List<Contact> loadContacts(String username) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTACT_FILE + username + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                contacts.add(new Contact(parts[0], parts[1]));
            }
        } catch (IOException e) {
            System.out.println("No saved contacts found.");
        }
        return contacts;
    }
}

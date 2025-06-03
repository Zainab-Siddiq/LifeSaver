import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.util.List;
import java.util.ArrayList;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, registerButton;
    private LoginSystem loginSystem;

    public LoginGUI() {
        loginSystem = new LoginSystem();
        setTitle("LifeSaver Login System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Set background image
        setContentPane(new JLabel(new ImageIcon("background.jpg")));
        getContentPane().setLayout(null);

        // Login box panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(255, 255, 255, 0)); // Start fully transparent
        loginPanel.setBounds(150, 80, 300, 220);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 180, 25);
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 60, 80, 25);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 180, 25);
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 110, 100, 30);
        loginButton.setBackground(new Color(135, 206, 235));
        loginPanel.add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(160, 110, 100, 30);
        registerButton.setBackground(new Color(144, 238, 144));
        loginPanel.add(registerButton);

        add(loginPanel);
        fadeInPanel(loginPanel);

        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> register());

        setVisible(true);
    }

    private void fadeInPanel(JPanel panel) {
        final JPanel finalPanel = panel;
        final float[] alpha = {0.0f};
        Timer timer = new Timer(40, null);
        timer.addActionListener(e -> {
            alpha[0] += 0.05f;
            if (alpha[0] >= 1.0f) {
                alpha[0] = 1.0f;
                timer.stop();
            }
            finalPanel.setBackground(new Color(255, 255, 255, (int)(alpha[0] * 255)));
            finalPanel.repaint();
        });
        timer.start();
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        int count = Integer.parseInt(JOptionPane.showInputDialog(this, "How many emergency contacts?"));
        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String name = JOptionPane.showInputDialog(this, "Enter contact name " + (i + 1));
            String phone = JOptionPane.showInputDialog(this, "Enter contact phone " + (i + 1));
            contacts.add(new Contact(name, phone));
        }

        if (loginSystem.register(username, password, contacts)) {
            JOptionPane.showMessageDialog(this, "Registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (loginSystem.login(username, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            List<Contact> contacts = loginSystem.loadContacts(username);
            String[] options = {"Edit Contacts", "Send Alert", "View Contacts"};
            int choice = JOptionPane.showOptionDialog(this, "Choose an action", "Post-login",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice == 0) { // Edit Contacts
                int count = Integer.parseInt(JOptionPane.showInputDialog(this, "How many contacts to add?"));
                for (int i = 0; i < count; i++) {
                    String name = JOptionPane.showInputDialog(this, "Enter contact name " + (i + 1));
                    String phone = JOptionPane.showInputDialog(this, "Enter contact phone " + (i + 1));
                    contacts.add(new Contact(name, phone));
                }
                loginSystem.saveContacts(username, contacts);
                JOptionPane.showMessageDialog(this, "Contacts updated.", "Updated", JOptionPane.INFORMATION_MESSAGE);
            }

            if (choice == 1) { // Send Alert
                String phone = JOptionPane.showInputDialog(this, "Enter your phone number:");
                double latitude = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter latitude:"));
                double longitude = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter longitude:"));

                Location location = new Location(latitude, longitude);
                Citizen citizen = new Citizen(username, phone, location);
                for (Contact c : contacts) {
                    citizen.addContact(c);
                }

                AlertSystem system = new AlertSystem();
                system.triggerAlerts(citizen);

                JOptionPane.showMessageDialog(this, "\uD83D\uDEA8 Alert sent to emergency contacts!", "Alert Triggered", JOptionPane.WARNING_MESSAGE);
            }

            if (choice == 2) { // View Contacts
                if (contacts.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No contacts found.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Contact c : contacts) {
                        sb.append(c.getName()).append(" - ").append(c.getPhone()).append("\n");
                    }
                    JOptionPane.showMessageDialog(this, sb.toString(), "Saved Contacts", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Login failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}

# 🚨 LifeSaver – Emergency Contact & Location Tracker

A Java-based emergency alert simulation system with a login and registration system, emergency contact management, and a Swing GUI interface.

## 💡 Features

- ✅ User registration and login with file-based storage
- 📇 Emergency contact entry, edit, and saving per user
- 🌍 Alert sending with simulated location coordinates
- 💻 Beautiful Java Swing GUI with styled components
- 🗃️ Persistent data using file handling (no database)


## 🧱 Technologies Used

- Java (OOP)
- Java Swing (GUI)
- File I/O in Java


## 🧑‍💻 Object-Oriented Design

| Class         | Role                                                                 |
|---------------|----------------------------------------------------------------------|
| `User`        | Abstract base class for common user fields                           |
| `Citizen`     | Inherits from User; manages emergency contacts and sends alerts      |
| `Contact`     | Holds emergency contact information                                  |
| `Location`    | Stores latitude and longitude                                        |
| `AlertSystem` | Sends alert to all registered contacts of the user                   |
| `LoginSystem` | Handles login, registration, and file operations                     |
| `LoginGUI`    | Swing-based graphical interface for login, registration, and alerts  |


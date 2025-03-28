# Boost_PhysioBookingSystem

```
BoostPhysioBookingSystem/
│── src/
│   ├── boostphysio/
│   │   │   │   ├── BoostPhysioBookingSystem.java
│   │   │   │   ├── Patient.java
│   │   │   │   ├── Physiotherapist.java
│   │   │   │   ├── Appointment.java
│   ├── test/
│   │   ├──boostphysio/
│   │   │   │   ├── BoostPhysioBookingSystemTest.java 
│── lib/                   
│── dist/                
│   ├── BoostPhysioBookingSystem.jar  # ✅ Executable JAR file
│── docs/                  
│── config/                
│── .gitignore
│── build.xml             
│── README.md
```


Boost Physio Booking System is a Java-based console application that allows patients to book, view, and cancel physiotherapy appointments with registered physiotherapists.

## Features
- View available physiotherapists and their expertise.
- Book an appointment with a physiotherapist.
- Cancel an appointment.
- View all scheduled appointments.
- Persistent list of physiotherapists and sample patients.
- Generate Report
- Mark Attendance for appointment


## Prerequisites
Ensure you have the following installed on your system:
- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt

## How to Run
### Running from Source Code
1. Clone this repository or download the source code.
2. Open a terminal or command prompt and navigate to the project directory.
3. Compile the Java files using:
   ```sh
   javac BoostPhysioBookingSystem.java
   ```
4. Run the application:
   ```sh
   java BoostPhysioBookingSystem
   ```

### Running the JAR File
If you have a compiled JAR file (`Boost_PhysioBookingSystem.jar`), you can run it using the following command:
   ```sh
   java -jar Boost_PhysioBookingSystem.jar
   ```

## Sample Patients
Each patient has a unique ID and a common Nigerian name. The first two patients are:
- **Patient 101** - Alice
- **Patient 102** - Bob

Other patients include:
- Emeka
- Aisha
- Tunde
- Chinedu
- Fatima
- Bolu
- Ngozi
- Ibrahim
- Chioma
- Oluwatobi
- Esther
- Samuel
- Adewale
- Grace
- Hassan
- Kemi
- Ezekiel
- Bukola
- Uchenna
- Mary

## Sample Physiotherapists
Each physiotherapist specializes in a particular area of physiotherapy. The list includes:
- **Dr. Smith** - Sports Injuries
- **Dr. Johnson** - Neurological Rehab
- **Dr. Alonge** - Knee Surgery
- **Dr. Fadahunsi** - Back Pain
- **Dr. Tomisin** - Posture Correction
- **Dr. Daniel** - Spinal Therapy

## Appointment Booking
To book an appointment:
1. Select "Book an Appointment" from the menu.
2. Enter the patient ID.
3. Enter the physiotherapist’s name.
4. Select an available appointment time slot.

## Appointment Cancellation
To cancel an appointment:
1. Select "Cancel an Appointment" from the menu.
2. Enter the patient ID.
3. Choose the time slot to cancel.

## License
This project is open-source and free to use. Contributions are welcome!


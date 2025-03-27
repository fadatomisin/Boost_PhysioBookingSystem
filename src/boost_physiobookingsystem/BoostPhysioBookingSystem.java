import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoostPhysioBookingSystem {
    private static List<Physiotherapist> physiotherapists = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupData();
        menu();
    }

    public static void setupData() {
        
        Physiotherapist p1 = new Physiotherapist("Dr. Smith", "Sports Injuries");
        Physiotherapist p2 = new Physiotherapist("Dr. Johnson", "Neurological Rehab");
        Physiotherapist p3 = new Physiotherapist("Dr. Alonge", "Knee Surgery");
        Physiotherapist p4 = new Physiotherapist("Dr. Fadahunsi", "Back Pain");
        Physiotherapist p5 = new Physiotherapist("Dr. Tomisin", "Posture Correction");
        Physiotherapist p6 = new Physiotherapist("Dr. Daniel", "Spinal Therapy");

        physiotherapists.add(p1);
        physiotherapists.add(p2);
        physiotherapists.add(p3);
        physiotherapists.add(p4);
        physiotherapists.add(p5);
        physiotherapists.add(p6);


        String[] patientNames = {"Alice", "Bob", "Tunde", "Chinedu", "Fatima", "Bolu", "Ngozi", "Ibrahim", "Chioma", "Oluwatobi", "Esther", "Samuel", "Adewale", "Grace", "Hassan", "Kemi", "Ezekiel", "Bukola", "Uchenna", "Mary"};
        for (int i = 0; i < patientNames.length; i++) {
            patients.add(new Patient(101 + i, patientNames[i]));
        }

        p1.addAppointment(new Appointment(p1, "Physio Therapy", "Monday 10 AM"));
        p1.addAppointment(new Appointment(p1, "Muscle Recovery", "Tuesday 2 PM"));
        p2.addAppointment(new Appointment(p2, "Stroke Rehab", "Wednesday 1 PM"));
        p2.addAppointment(new Appointment(p2, "Neurological Therapy", "Friday 11 AM"));
        p3.addAppointment(new Appointment(p3, "Knee Surgery", "Tuesday 12 PM"));
        p3.addAppointment(new Appointment(p3, "Post-Surgery Checkup", "Thursday 4 PM"));
        p4.addAppointment(new Appointment(p4, "Lower Back Therapy", "Thursday 9 AM"));
        p4.addAppointment(new Appointment(p4, "Pain Management", "Monday 3 PM"));
        p5.addAppointment(new Appointment(p5, "Posture Alignment", "Friday 3 PM"));
        p5.addAppointment(new Appointment(p5, "Spinal Adjustment", "Wednesday 10 AM"));
        p6.addAppointment(new Appointment(p6, "Spinal Decompression", "Saturday 11 AM"));
        p6.addAppointment(new Appointment(p6, "Chronic Pain Therapy", "Tuesday 5 PM"));
    }

    private static void menu() {
        while (true) {
            System.out.println("\n--- Boost Physio Clinic Management ---");
            System.out.println("1. View Physiotherapists");
            System.out.println("2. Book an Appointment");
            System.out.println("3. Cancel an Appointment");
            System.out.println("4. View All Appointments");
            System.out.println("5. Search Physiotherapists by Expertise");
            System.out.println("6. Generate End-of-Term Report");
            System.out.println("7. Exit");
            
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    viewPhysiotherapists();
                    break;
                case 2:
                    bookAppointment();
                    break;
                case 3:
                    cancelAppointment();
                    break;
                case 4:
                    viewAllAppointments();
                    break;
                case 5:
                    searchByExpertise();
                    break;
                case 6:
                    generateEndOfTermReport();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void viewPhysiotherapists() {
        System.out.println("\nAvailable Physiotherapists:");
        for (Physiotherapist p : physiotherapists) {
            System.out.println("- " + p.getName() + " (" + p.getExpertise() + ")");
        }
    }

    private static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter Physiotherapist Name: ");
        String physioName = scanner.nextLine();
        Physiotherapist physio = findPhysiotherapistByName(physioName);

        if (physio == null) {
            System.out.println("Physiotherapist not found.");
            return;
        }

        System.out.println("Available Appointments:");
        for (Appointment appointment : physio.getAppointments()) {
            if (appointment.toString().contains("Available")) {
                System.out.println(appointment);
            }
        }

        System.out.print("Enter Time Slot to Book: ");
        String timeSlot = scanner.nextLine();
        for (Appointment appointment : physio.getAppointments()) {
            if (appointment.toString().contains(timeSlot) && appointment.toString().contains("Available")) {
                appointment.book(patient);
                System.out.println("Appointment booked successfully!");
                return;
            }
        }
        System.out.println("No available appointment found.");
    }

    private static void cancelAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();  

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Your Appointments:");
        for (Appointment appointment : patient.getBookedAppointments()) {
            System.out.println(appointment);
        }

        System.out.print("Enter Time Slot to Cancel: ");
        String timeSlot = scanner.nextLine();
        for (Appointment appointment : patient.getBookedAppointments()) {
            if (appointment.toString().contains(timeSlot)) {
                appointment.cancel();
                System.out.println("Appointment cancelled.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    public static void viewAllAppointments() {
        for (Physiotherapist physio : physiotherapists) {
            physio.displayAppointments();
        }
    }
    
    private static void searchByExpertise() {
    System.out.print("Enter area of expertise: ");
    String expertise = scanner.nextLine().toLowerCase();
    
    List<Physiotherapist> filteredPhysios = new ArrayList<>();
    for (Physiotherapist p : physiotherapists) {
        if (p.getExpertise().toLowerCase().contains(expertise)) {
            filteredPhysios.add(p);
        }
    }

    if (filteredPhysios.isEmpty()) {
        System.out.println("No physiotherapist found with expertise in " + expertise);
    } else {
        System.out.println("\nPhysiotherapists specializing in " + expertise + ":");
        for (Physiotherapist p : filteredPhysios) {
            System.out.println("- " + p.getName() + " (" + p.getExpertise() + ")");
            p.displayAppointments();
        }
    }
}


    public static Patient findPatientById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static Physiotherapist findPhysiotherapistByName(String name) {
        return physiotherapists.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    
    private static void generateEndOfTermReport() {
    System.out.println("\n--- End of Term Report ---");

    // Print all appointments
    for (Physiotherapist p : physiotherapists) {
        System.out.println("\nPhysiotherapist: " + p.getName());
        for (Appointment a : p.getAppointments()) {
            String status = a.isBooked() ? (a.isAttended() ? "Attended" : "Booked") : "Available";
            System.out.println("  - " + a.getTreatmentName() + " | Patient: " + (a.getPatient() != null ? a.getPatient().getName() : "None") + " | Time: " + a.getTimeSlot() + " | Status: " + status);
        }
    }

    // Sort physiotherapists by number of attended appointments
    physiotherapists.sort((p1, p2) -> Integer.compare(p2.getAttendedAppointmentsCount(), p1.getAttendedAppointmentsCount()));

    // Print physiotherapist ranking
    System.out.println("\n--- Physiotherapist Ranking (by attended appointments) ---");
    for (Physiotherapist p : physiotherapists) {
        System.out.println(p.getName() + " - " + p.getAttendedAppointmentsCount() + " attended appointments");
    }
}

}

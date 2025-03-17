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
        
        physiotherapists.add(p1);
        physiotherapists.add(p2);
        physiotherapists.add(p3);


        Patient patient1 = new Patient(101, "Alice");
        Patient patient2 = new Patient(102, "Bob");
        patients.add(patient1);
        patients.add(patient2);

        p1.addAppointment(new Appointment(p1, "Physio Therapy", "Monday 10 AM"));
        p1.addAppointment(new Appointment(p1, "Muscle Recovery", "Tuesday 2 PM"));
        p2.addAppointment(new Appointment(p2, "Stroke Rehab", "Wednesday 1 PM"));
        p3.addAppointment(new Appointment(p3, "Knee Surgery", "Tuesday 12 PM"));
    }

    private static void menu() {
        while (true) {
            System.out.println("\n--- Boost Physio Clinic Management ---");
            System.out.println("1. View Physiotherapists");
            System.out.println("2. Book an Appointment");
            System.out.println("3. Cancel an Appointment");
            System.out.println("4. View All Appointments");
            System.out.println("5. Exit");
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

    public static Patient findPatientById(int id) {
        return patients.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public static Physiotherapist findPhysiotherapistByName(String name) {
        return physiotherapists.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}

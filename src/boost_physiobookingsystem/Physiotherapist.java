import java.util.ArrayList;
import java.util.List;

public class Physiotherapist {
    private String name;
    private String expertise;
    private List<Appointment> appointments;

    public Physiotherapist(String name, String expertise) {
        this.name = name;
        this.expertise = expertise;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public void displayAppointments() {
        System.out.println("Appointments for " + name + " (" + expertise + "):");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
}

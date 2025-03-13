import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private int id;
    private List<Appointment> bookedAppointments;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
        this.bookedAppointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Appointment> getBookedAppointments() {
        return bookedAppointments;
    }

    public void bookAppointment(Appointment appointment) {
        bookedAppointments.add(appointment);
    }

    public void cancelAppointment(Appointment appointment) {
        bookedAppointments.remove(appointment);
    }
}

public class Appointment {
    private Physiotherapist physiotherapist;
    private String treatmentName;
    private String timeSlot;
    private Patient patient; // Null if not booked
    private boolean attended;

    public Appointment(Physiotherapist physiotherapist, String treatmentName, String timeSlot) {
        this.physiotherapist = physiotherapist;
        this.treatmentName = treatmentName;
        this.timeSlot = timeSlot;
        this.patient = null; // Default to available
        this.attended = false;
    }

    public boolean isBooked() {
        return patient != null;
    }

    public void book(Patient patient) {
        if (this.patient == null) {
            this.patient = patient;
        }
    }

    public void cancel() {
        this.patient = null;
    }

    public boolean isAttended() {
        return attended;
    }

    public void markAsAttended() {
        this.attended = true;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return treatmentName + " at " + timeSlot + " - " + (isBooked() ? "Booked by " + patient.getName() : "Available");
    }
}

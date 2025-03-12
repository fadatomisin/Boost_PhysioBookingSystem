public class Appointment {
    private Physiotherapist physiotherapist;
    private Patient patient;
    private String treatment;
    private String timeSlot;
    private String status;  // "Booked", "Cancelled", "Attended"

    public Appointment(Physiotherapist physiotherapist, String treatment, String timeSlot) {
        this.physiotherapist = physiotherapist;
        this.treatment = treatment;
        this.timeSlot = timeSlot;
        this.status = "Available";
    }

    public void book(Patient patient) {
        if (status.equals("Available")) {
            this.patient = patient;
            this.status = "Booked";
            patient.bookAppointment(this);
        } else {
            System.out.println("Appointment not available.");
        }
    }

    public void cancel() {
        if (status.equals("Booked")) {
            this.patient.cancelAppointment(this);
            this.patient = null;
            this.status = "Cancelled";
        }
    }

    public String toString() {
        return "Treatment: " + treatment + ", Time: " + timeSlot + ", Status: " + status +
               (patient != null ? ", Patient: " + patient.getName() : "");
    }
}

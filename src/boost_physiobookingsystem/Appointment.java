public class Appointment {
    private Physiotherapist physiotherapist;
    private Patient patient;
    private String treatment;
    private String timeSlot;
    private String status;  // "Available", "Booked", "Cancelled"

    public Appointment(Physiotherapist physiotherapist, String treatment, String timeSlot) {
        this.physiotherapist = physiotherapist;
        this.treatment = treatment;
        this.timeSlot = timeSlot;
        this.status = "Available";
    }

    public void book(Patient patient) {
        if (this.status.equals("Available")) {
            this.patient = patient;
            this.status = "Booked";
            patient.bookAppointment(this);
        } else {
            System.out.println("Appointment not available.");
        }
    }

    public void cancel() {
        if (this.status.equals("Booked") && this.patient != null) {  // Prevent null error
            this.patient.cancelAppointment(this);
            this.patient = null;
            this.status = "Cancelled";
        }
    }

    public String getStatus() {
        return status;  // ✅ Use the correct `status` field instead of `isBooked`
    }

    @Override
    public String toString() {
        return "Treatment: " + treatment + ", Time: " + timeSlot + ", Status: " + status +
               (patient != null ? ", Patient: " + patient.getName() : "");
    }
}

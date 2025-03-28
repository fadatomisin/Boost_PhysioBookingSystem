public class Appointment {
    private Physiotherapist physiotherapist;
    private String treatmentName;
    private String timeSlot;
    private Patient patient; // Null if not booked
    private boolean attended;
    private boolean isAttended; 

    public Appointment(Physiotherapist physiotherapist, String treatmentName, String timeSlot) {
        this.physiotherapist = physiotherapist;
        this.treatmentName = treatmentName;
        this.timeSlot = timeSlot;
        this.patient = null; // Default to available
        this.attended = false;
        this.isAttended = false;
    }

    public boolean isBooked() {
        return patient != null;
    }
    public boolean isAttended() {
        return isAttended;
    }

    public void book(Patient patient) {
        if (this.patient == null) {
            this.patient = patient;
        }
    }

    public void cancel() {
        this.patient = null;
         this.isAttended = false;
    }

    public void markAsAttended() {
        if (patient != null) {
            this.isAttended = true;
        } else {
            System.out.println("No patient booked for this appointment.");
        }
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
        return "Time Slot: " + timeSlot + " | Patient: " + 
               (patient != null ? patient.getName() : "Available") + 
               " | Attended: " + (isAttended ? "Yes" : "No");
    }
}

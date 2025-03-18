import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class BoostPhysioBookingSystemTest {
    private BoostPhysioBookingSystem system;

    @Before
    public void setUp() {
        system = new BoostPhysioBookingSystem();
        system.setupData();
        
   
    }

    @Test
    public void testFindPhysiotherapistByName() {
        Physiotherapist physio = system.findPhysiotherapistByName("Dr. Smith");
        assertNotNull("Physiotherapist should not be null", physio);
        assertEquals("Dr. Smith", physio.getName());
    }

    @Test
    public void testFindPatientById() {
        Patient patient = system.findPatientById(101);
        assertNotNull("Patient should not be null", patient);
        assertEquals(101, patient.getId());
    }

    @Test
    public void testBookAppointment() {
        Patient patient = system.findPatientById(101);
        Physiotherapist physio = system.findPhysiotherapistByName("Dr. Smith");
        
        assertNotNull("Patient should not be null", patient);
        assertNotNull("Physiotherapist should not be null", physio);
        
        List<Appointment> appointments = physio.getAppointments();
        assertFalse("Appointments should not be empty", appointments.isEmpty());
        
        Appointment appointment = appointments.get(0);
        appointment.book(patient);
        assertEquals("Booked", appointment.getStatus());
    }

    @Test
    public void testCancelAppointment() {
        Patient patient = system.findPatientById(101);
        Physiotherapist physio = system.findPhysiotherapistByName("Dr. Smith");
        
        assertNotNull("Patient should not be null", patient);
        assertNotNull("Physiotherapist should not be null", physio);
        
        List<Appointment> appointments = physio.getAppointments();
        assertFalse("Appointments should not be empty", appointments.isEmpty());
        
        Appointment appointment = appointments.get(0);
        appointment.book(patient);
        
        appointment.cancel();
        assertEquals("Cancelled", appointment.getStatus());
    }
}

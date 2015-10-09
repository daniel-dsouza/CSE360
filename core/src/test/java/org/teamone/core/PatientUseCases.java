/**
 * Created by Lin on 2015/10/8.
 */
import org.junit.Before;
import org.junit.Test;
import org.teamone.core.Patient;
import org.teamone.core.PatientManipulation;

public class PatientUseCases {
    //this is for all use cases of patient: such as send alert/update info/schedule appointment.....
    private Patient patient;

    @Before
    public void setUp()
    {
        patient = new Patient();
        patient.setAddress("Tempe");
        patient.setPatientID(20151009);
        patient.setAge(18);
        patient.setGender("male");
        patient.setSSN(123456789);
        patient.setPhone(654321);
        patient.setOccupation("student");
        patient.setMedicalHistory("No disease before.");
    }

    @Test
    public void tester()
    {
        int x = PatientManipulation.UpdatePersonalInfo(patient);
        System.out.print(x);
    }

}
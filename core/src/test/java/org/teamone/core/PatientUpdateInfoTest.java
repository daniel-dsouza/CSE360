/**
 * Created by Lin on 2015/10/8.
 */
import org.junit.Before;
import org.junit.Test;
import org.teamone.core.Patient;
import org.teamone.core.SQL.HSPRegistration;

public class PatientUpdateInfoTest {

    private Patient test;

    @Before
    public void setUp()
    {
        test = new Patient();
        test.setPatientID(106);
        test.setfName("luffy");
        test.setlName("monkey");
        test.setAddress("Eastern Ocean");
        test.setEmail("luffy@asu.edu");
        test.setPhone(13230932);
        test.setSSN(987654321);
        test.setInsurance("fight");
        test.setAge(21);
        test.setGender("male");
        test.setPassword("hiRyan");
    }

    @Test
    public void tester()
    {
        if(HSPRegistration.RegisterNewPatient(test))
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        //Person p1 = SQL.cehck
    }

}
/**
 * Created by Lin on 2015/10/8.
 */
import org.junit.Before;
import org.junit.Test;
import org.teamone.core.Patient;
import org.teamone.core.SQL.PatientUpdateInfo;

public class PatientUseCases {
    //this is for all use cases of patient: such as send alert/update info/schedule appointment.....
    private Patient test;

    @Before
    public void setUp()
    {
        test = new Patient();
        test.setPatientID(102);
        test.setfName("Lin");
        test.setlName("Haisheng");
        test.setAddress("Tempe");
        test.setEmail("xxxxxxxx@asu.edu");
        test.setPhone(1234567890);
        test.setSSN(123456789);
        test.setInsurance("nope");
        test.setAge(18);
        test.setGender("male");
    }

    @Test
    public void tester()
    {
        if(PatientUpdateInfo.UpdatePersonalInfo(test))
        {
            System.out.println("*********************Update successful************************");
        }
        else
            System.out.println("\n************************Update failed********************");
        //Person p1 = SQL.cehck
    }

}
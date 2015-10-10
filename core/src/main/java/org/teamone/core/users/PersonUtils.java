package org.teamone.core.users;

import org.teamone.core.appointments.Appointments;

import java.util.ArrayList;

/**
 * Created by daniel on 10/10/15.
 */
public class PersonUtils {
    /**
     * This is static (aka singleton class) that will have utilities
     */

    /**
     * Method returns a list doctors.
     * @param staff: object populated with required information
     * @return
     */
    public ArrayList<Staff> getStaff (Staff staff) {
        //TODO: getStaffList implementation
        return null;
    }

    /**
     * Returns a list of patients
     * @param patient: patient object with required information
     * @return
     */
    public ArrayList<Patient> getPatients (Patient patient) {
        //TODO: getPatientList implementation
        return null;
    }

    public Appointments getStaffAppointment (Staff staff) {
        //TODO: getPatientList implementation
        return null;
    }


    /**
     * Returns a list of patients based on doctors.
     * @param staff
     * @return
     */
    public ArrayList<Patient> getPatientByStaff (Staff staff) {
        //TODO: getPatientByStaff
        return null;
    }
}

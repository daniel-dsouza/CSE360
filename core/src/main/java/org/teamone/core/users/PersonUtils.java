package org.teamone.core.users;

import org.teamone.core.appointments.Appointment;

import java.sql.*;
import java.util.ArrayList;

//import org.teamone.core.Patient;

/**
 * Created by daniel on 10/10/15.
 */
public class PersonUtils {
    /**
     * This is static (aka singleton class) that will have utilities
     */
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static PreparedStatement preparedStatementPerson = null;
    private static ResultSet resultSet = null;

    /**
     * Method returns a list doctors.
     * @param staff: object populated with required information
     * @return
     */
    public static ArrayList<Staff> getStaffList (Staff staff) {
        ArrayList<Staff> arrayOfDoctors = null;


        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();

            String specialty = staff.getSpecialty();

            preparedStatement = connect.prepareStatement("SELECT person.name as name, person.userID as staffID FROM person WHERE person.userID IN (SELECT staff.staffID FROM staff WHERE staff.specialty = ?) ;");
            preparedStatement.setString(1, specialty);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSet rs2 = rs;

            while(rs.next()) {
                //Retrieve by column name

                Staff newStaff = null;
                newStaff.setName(rs.getString("name"));
                newStaff.setStaffID(rs.getInt("staffID"));

                arrayOfDoctors.add(newStaff);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            arrayOfDoctors = null;
        } finally {
            close();
        }
        return arrayOfDoctors;

    }

    // You need to close the resultSet
    private static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }


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

    public Appointment getDoctorAppointment (Staff staff) {
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

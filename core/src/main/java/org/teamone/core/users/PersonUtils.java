package org.teamone.core.users;

import org.teamone.core.SQL.PasswordSQL;
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
    private static PreparedStatement preparedStatementPatient = null;
    private static ResultSet resultSet = null;

    /**
     * Method returns a list doctors.
     * @param String: Specialty to find in sql
     * @return ArrayList: Arraylist of staff objects
     */
    public static ArrayList<Staff> getStaffList (String specialty) {
        ArrayList<Staff> arrayOfDoctors = new ArrayList<Staff>();


        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", PasswordSQL.mySQLpass);

            //String specialty = staff.getSpecialty();

            preparedStatement = connect.prepareStatement("SELECT person.name as name, person.userID as staffID FROM person WHERE person.userID IN (SELECT staff.staffID FROM staff WHERE staff.specialty = ?) ;");
            preparedStatement.setString(1, specialty);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //Retrieve by column name

                Staff newStaff = new Staff();
                newStaff.setName(resultSet.getString("name"));
                newStaff.setStaffID(resultSet.getInt("staffID"));

                arrayOfDoctors.add(newStaff);
            }
        } catch (Exception e) {
            System.out.println(e);
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
            System.out.println(e);
        }


    }

    /**
     * Returns a list of patients
     * @param String: Find people
     * @return ArrayList: Arraylist of Patient objects
     */
    public static ArrayList<Patient> getPatients(String queryName) {

        ArrayList<Patient> patientList = new ArrayList<Patient>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", PasswordSQL.mySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatementPatient = connect.prepareStatement("select name as patientName from person where occupation = 'patient' and name like '%" + queryName + "%';");
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            ResultSet rs = preparedStatementPatient.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setName(rs.getString("patientName"));
                patientList.add(patient);
            }

        } catch (Exception e) {
            System.out.println(e);
            patientList = null;

        } finally {
            close();
        }
        return patientList;
    }

    public static ArrayList<Appointment> getPatientsAppointment(String patientName) {

        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", PasswordSQL.mySQLpass);

            preparedStatementPatient = connect.prepareStatement("select userID from person where name = ?");
            preparedStatementPatient.setString(1,patientName);
            ResultSet rs2 = preparedStatementPatient.executeQuery();
            rs2.next();
            int patientID = rs2.getInt("userID");

            preparedStatementPatient = connect.prepareStatement("select date, time, reason, doctorID, patientID from appointment where patientID = " + patientID );
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            ResultSet rs = preparedStatementPatient.executeQuery();

            while (rs.next()) {
                Appointment appt = new Appointment();
                appt.setDate(rs.getString("date"));
                appt.setTime(rs.getString("time"));
                appt.setReason(rs.getString("reason"));
                appt.setDoctorID(rs.getInt("doctorID"));
                appt.setPatientID(rs.getInt("patientID"));
                apptList.add(appt);
            }

        } catch (Exception e) {
            System.out.println(e);
            apptList = null;
        } finally {
            close();
        }
        return apptList;
    }

    public Appointment getDoctorAppointment(Staff staff) {
        //TODO: getPatientList implementation
        return null;
    }

    /**
     * Returns a list of patients based on doctors.
     * @param staff: Given a staff object
     * @return ArrayList: List of Patients
     */
    public ArrayList<Patient> getPatientByStaff (Staff staff) {
        //TODO: getPatientByStaff
        return null;
    }
}

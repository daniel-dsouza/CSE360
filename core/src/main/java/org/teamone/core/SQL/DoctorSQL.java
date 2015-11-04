package org.teamone.core.SQL;

import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Lin on 2015/10/19.
 */
public class DoctorSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * get specialty assigned to doctor id
     * @param staff staff Object with valid staff ID
     * @return String with specialty
     */
    public static String getSpecialty(int staff) {
        //Staff staff = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("SELECT specialty FROM staff where staffID = ?");
            preparedStatement.setInt(1, staff);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            temp = resultSet.getString("specialty");

        } catch (Exception e) {
            System.out.println(e);
            temp = null;
        } finally {
            close();
        }
        return temp;
    }

    /**
     * Method returns a list doctors.
     * @param specialty: String to find in sql
     * @return ArrayList: Arraylist of staff objects
     */
    public static ArrayList<Staff> getListDoctorSpecialty (String specialty) {
        ArrayList<Staff> arrayOfDoctors = new ArrayList<Staff>();
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            //System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            //String specialty = staff.getSpecialty();

            preparedStatement = connect.prepareStatement("SELECT person.name as name, person.userID as staffID FROM person WHERE person.userID IN (SELECT staff.staffID FROM staff WHERE staff.specialty = ?) ;");
            preparedStatement.setString(1, specialty);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //Retrieve by column name

                Staff newStaff = new Staff();
                newStaff.setName(resultSet.getString("name"));
                newStaff.setUserID(resultSet.getInt("staffID"));
                newStaff.splitName(resultSet.getString("name"));

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

    /**
     * Method returns a list Appointments for doctor specialty.
     *
     * @param specialty: String Specialty to find in sql.
     * @return ArrayList: Arraylist of appointment objects
     */
    public static ArrayList<Appointment> getListSpecialtyPatient(String specialty) {
        ArrayList<Appointment> arrayOfAppt = new ArrayList<Appointment>();
        try {
            ArrayList<Staff> arrayOfDoctors = getListDoctorSpecialty(specialty);//first search for specialty

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            //System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            for (int i = 0; i < arrayOfDoctors.size(); i++) {
                preparedStatement = connect.prepareStatement("SELECT date, time, patientID, serialNumber FROM appointment WHERE doctorID = ? AND patientID IS NOT NULL;");
                preparedStatement.setInt(1, arrayOfDoctors.get(i).getUserID());
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    //Retrieve by column name

                    Appointment new1 = new Appointment();
                    new1.setDate(resultSet.getString("date"));
                    new1.setTime(resultSet.getString("time"));
                    new1.setPatientID(resultSet.getInt("patientID"));
                    new1.setDoctorID(arrayOfDoctors.get(i).getUserID());
                    new1.setAppointmentID(resultSet.getInt("serialNumber"));
                    arrayOfAppt.add(new1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            arrayOfAppt = null;
        } finally {
            close();
        }
        return arrayOfAppt;

    }

    /**
     * get all data from SQL with a staff ID
     * @param staff staff Object with valid staff ID
     * @return staff object with all data filled in
     */
    public static Staff getStaffComplete(Staff staff) {
        //Staff staff = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = staff.getUserID();
            String mh = null;

            preparedStatement = connect.prepareStatement("SELECT p2.name, p2.emailID, p.occupation, p.specialty, p.patientID, p.schedule FROM staff p, person p2 where staffID = ? and userID = ?");
            preparedStatement.setInt(1, staff.getUserID());
            preparedStatement.setInt(2, staff.getUserID());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            staff.setOccupation(resultSet.getString("p.occupation"));
            staff.setSpecialty(resultSet.getString("p.specialty"));
            staff.setPatientID(resultSet.getInt("p.patientID"));
            staff.setSchedule(resultSet.getString("p.schedule"));
            staff.setName(resultSet.getString("p2.name"));
            staff.splitName(resultSet.getString("p2.name"));
            staff.setEmail(resultSet.getString("p2.emailID"));


        } catch (Exception e) {
            System.out.println(e);
            staff = null;
        } finally {
            close();
        }
        return staff;
    }

    /**
     * Method returns a list doctors.
     * @param doc: Doctor with valid id
     * @return ArrayList: Arraylist of patients objects
     */
    public static ArrayList<Patient> getDoctorPatientsList (Doctor doc) {
        ArrayList<Patient> arrayOfPatient = new ArrayList<Patient>();
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = doc.getUserID();

            preparedStatement = connect.prepareStatement("SELECT patientID from appointment where doctorID = ? and patientID IS NOT NULL;");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //Retrieve by column name

                Patient new1 = new Patient();
                new1.setUserID(resultSet.getInt("patientID"));
                //new1 = PatientSQL.getPatientComplete(new1);

                arrayOfPatient.add(new1);
            }
        } catch (Exception e) {
            System.out.println(e);
            arrayOfPatient = null;
        } finally {
            close();
        }
        return arrayOfPatient;

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

}

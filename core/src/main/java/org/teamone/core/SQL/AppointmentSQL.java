package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AppointmentSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * @param readMe Appointment Object with valid doctorID
     * @return list of appointments by doctor
     */
    public static List<Appointment> viewAppointmentByDoctor(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID, serialNumber FROM appointment where doctorID = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment new1 = new Appointment();
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int patID = resultSet.getInt("patientID");

                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Patient ID:\t" + patID);*///debugging

                new1.setDate(date);
                new1.setTime(time);
                new1.setReason(reason);
                new1.setPatientID(patID);
                new1.setAppointmentID(resultSet.getInt("serialNumber"));
                a1.add(new1);

            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;
    }

    /**
     * Given an appoint with doctorID, Time, PatientID, and Date, return ID
     *
     * @param readMe Appointment Object with valid  doctorID, Time, PatientID, and Date,
     * @return appoint with appointmentID
     */
    public static Appointment getAppointmentID(Appointment readMe) {

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            int patID = readMe.getPatientID();
            String time = readMe.getTime();
            String date = readMe.getDate();
            preparedStatement = connect.prepareStatement("SELECT serialNumber FROM appointment where doctorID = ? and date = ? and time = ? and patientID = ?");
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            preparedStatement.setInt(4, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            readMe.setAppointmentID(resultSet.getInt("serialNumber"));

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
        return readMe;
    }

    /**
     * @param readMe Appointment Object with valid patientID
     * @return list of appointments by patient
     */

    public static List<Appointment> viewAppointmentByPatient(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID, serialNumber FROM appointment where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Appointment new1 = new Appointment();

                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int docID = resultSet.getInt("doctorID");
                Staff temp = new Staff();
                temp.setUserID(docID);
                Staff doc1 = DoctorSQL.getStaffComplete(temp);

                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                new1.setDate(date);
                new1.setTime(time);
                new1.setReason(reason);
                new1.setPatientID(docID);
                new1.setAppointmentID(resultSet.getInt("serialNumber"));
                new1.setDoctor(doc1);
                a1.add(new1);

            }

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;

    }

    /**
     * @param readMe Appointment Object with valid appointmentID
     * @return appointment by appointment ID
     */
    public static Appointment viewAppointmentByApptID(Appointment readMe) {


        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int appID = readMe.getAppointmentID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID, patientID FROM appointment where serialNumber = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, appID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set


            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String reason = resultSet.getString("reason");
            int docID = resultSet.getInt("doctorID");
            int patID = resultSet.getInt("patientID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging
            Patient temp = new Patient();
            temp.setUserID(patID);
            //temp = PatientSQL.getPatientComplete(temp);
            readMe.setPatient(temp);

            Doctor temp1 = new Doctor();
            temp1.setUserID(docID);
            readMe.setDoctor(temp1);

            readMe.setDate(date);
            readMe.setTime(time);
            readMe.setReason(reason);
            readMe.setPatientID(patID);


        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
        return readMe;

    }

    /**
     * Create appointment used by doctors
     * This is will use doctorID, date and time to edit the SQL.
     *
     * @param readMe Appointment Object with valid doctorID, date and time
     * @return Appointment
     */
    public static Boolean createAppointment(Appointment readMe) {
        Boolean Result;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();

            String insertApp = "INSERT INTO appointment "
                    + "(doctorID, date, time) VALUES"
                    + "(?,?,?);";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(insertApp);
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            checker = preparedStatement.executeUpdate();

            if (checker == 0) {
                Result = false;
            } else
                Result = true;

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;

        }
        return Result;
    }

    /**
     * Preloads the database with appointments
     * NO FRONTEND SHOULD CALL THIS
     *
     * @param readMe Appointment Object
     * @return boolean
     */
    public static boolean preloadAppointment(Appointment readMe) {
        boolean result = false;
        try {
            int checker = 0;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String insertApp = "INSERT INTO appointment "
                    + "(doctorID, date, time) VALUES"
                    + "(?,?,?);";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(insertApp);
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            checker = preparedStatement.executeUpdate();

            if (checker == 0)
                result = false;
            else
                result = true;

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            result = false;
        } finally {
            close();
        }
        return result;
    }
    /**
     * NULLS out the patientID and reason for an appointment
     *
     * @param oldID:  appointmentID to be nulled out
     * @return Boolean
     */
    public static Boolean delAppointmentAppt(int oldID) {
        Boolean Result;
        try {
            int checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);


            String nullApp = "UPDATE appointment SET reason = NULL, patientID = NULL WHERE serialNumber = ?;";
            preparedStatement = connect.prepareStatement(nullApp);
            preparedStatement.setInt(1, oldID);
            checker2 = preparedStatement.executeUpdate();

            if (checker2 == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * given an Appointment with valid info, and the old appointmentID,  this is "swap" appointments.
     * This is because the oldID needs to have the reason and patientID set to NULL. Thus "swapping" occurs.
     *
     * @param readMe Appointment Object with valid appointmentID
     * @return Boolean
     */
    public static Boolean swapAppointmentAppt(Appointment readMe, int oldID) {
        Boolean Result;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int appID = readMe.getAppointmentID();
            int patID = readMe.getPatientID();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                    + " reason = ?, patientID = ? WHERE serialNumber = ? ;";

            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, reason);
            preparedStatement.setInt(2, patID);
            preparedStatement.setInt(3, appID);

            checker = preparedStatement.executeUpdate();
            String nullApp = "UPDATE appointment SET reason = NULL, patientID = NULL WHERE serialNumber = ?;";
            preparedStatement = connect.prepareStatement(nullApp);
            preparedStatement.setInt(1, oldID);
            checker2 = preparedStatement.executeUpdate();

            if (checker == 0 | checker2 == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Schedule an existing appointment by Appointment ID. This is because SQL is preloaded with patientID set to NULL
     *
     * @param readMe Appointment Object with valid appointmentID
     * @return Boolean
     */
    public static Boolean schedAppointmentAppt(Appointment readMe) {
        Boolean Result;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int appID = readMe.getAppointmentID();
            int patID = readMe.getPatientID();
            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                    + " reason = ?, patientID = ? WHERE serialNumber = ? ;";

            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, reason);
            preparedStatement.setInt(2, patID);
            preparedStatement.setInt(3, appID);
            checker = preparedStatement.executeUpdate();


            if (checker == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Returns a list of patients' appointment
     *
     * @param patientName: String Name must be exact
     * @return ArrayList: Arraylist of Patient objects
     */
    public static ArrayList<Appointment> getPatientsAppointment(String patientName) {

        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("select userID from person where name = ?");
            preparedStatement.setString(1, patientName);
            ResultSet rs2 = preparedStatement.executeQuery();
            if (rs2.next()) {
                int patientID = rs2.getInt("userID");


                preparedStatement = connect.prepareStatement("select serialNumber, date, time, reason, doctorID, patientID from appointment where patientID = " + patientID);
                //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Appointment appt = new Appointment();
                    appt.setDate(rs.getString("date"));
                    appt.setTime(rs.getString("time"));
                    appt.setReason(rs.getString("reason"));
                    appt.setDoctorID(rs.getInt("doctorID"));
                    appt.setPatientID(rs.getInt("patientID"));
                    appt.setAppointmentID(rs.getInt("serialNumber"));
                    apptList.add(appt);
                }
            } else {
                System.out.println("\nName not found.");
                apptList = null;
            }
        } catch (Exception e) {
            System.out.println(e);
            apptList = null;
        } finally {
            close();
        }
        return apptList;
    }

    /**
     * Returns a list of Appointments available to doctor
     *
     * @param doc: Doctor with staff ID filled in
     * @return ArrayList: Arraylist of Appointment objects
     */
    public static ArrayList<Appointment> getAvailableDoctorTimes(Doctor doc) {
        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int docID = doc.getUserID();
            preparedStatement = connect.prepareStatement("select date, time, serialNumber from appointment where doctorID  = ? and patientID IS NULL");
            preparedStatement.setInt(1, docID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Appointment appt = new Appointment();
                appt.setDate(rs.getString("date"));
                appt.setTime(rs.getString("time"));
                appt.setAppointmentID(rs.getInt("serialNumber"));
                appt.setDoctorID(docID);
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


    /**
     * Method used for closing the sql library functions
     */
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

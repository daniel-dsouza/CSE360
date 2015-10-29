package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

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
            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID FROM appointment where doctorID = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            do {

                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int patID = resultSet.getInt("patientID");

                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Patient ID:\t" + patID);*///debugging

                readMe.setDate(date);
                readMe.setTime(time);
                readMe.setReason(reason);
                readMe.setPatientID(patID);

                a1.add(readMe);

            } while (resultSet.next());
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
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

            preparedStatement = connect.prepareStatement("SELECT serialNumber, date, time, reason, doctorID FROM appointment where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            do {
                Appointment temp = new Appointment();

                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int docID = resultSet.getInt("doctorID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                temp.setDate(date);
                temp.setTime(time);
                temp.setReason(reason);
                temp.setPatientID(docID);
                temp.setAppointmentID(resultSet.getInt("serialNumber"));

                a1.add(temp);

            }
            while (resultSet.next());
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
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
     * Edit the appointment. Can be used by patients, doctors, and HSP
     * This is will use doctorID, date and time to edit the SQL.
     *
     * @param readMe Appointment Object with valid doctorID, date and time
     * @return Appointment
     */
    public static Appointment editAppointment(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int patID = readMe.getPatientID();
            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                    + " reason = ?, patientID = ? WHERE doctorID = ? and date = ? and time = ?;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, reason);
            preparedStatement.setInt(2, patID);
            preparedStatement.setInt(3, docID);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, time);

            checker = preparedStatement.executeUpdate();
            System.out.println("checker for doctor==============" + checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                String insertApp = "INSERT INTO appointment "
                        + "(reason, patientID) VALUES"
                        + "(?,?) WHERE doctorID = ? and date = ? and time = ? ;";
                // PreparedStatements can use variables and are more efficient
                preparedStatement = connect.prepareStatement(insertApp);
                preparedStatement.setString(1, reason);
                preparedStatement.setInt(2, patID);
                preparedStatement.setInt(3, docID);
                preparedStatement.setString(4, date);
                preparedStatement.setString(5, time);
                preparedStatement.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        }
        return readMe;
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
     * Same as editAppointment, but will only use appointmentID
     *
     * @param readMe Appointment Object with valid appointmentID
     * @return appointment object
     */
    public static Appointment editAppointmentAppt(Appointment readMe) {
        Appointment a1 = new Appointment();

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
                a1 = null;
            else
                a1 = readMe;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
        return a1;

    }

    /**
     * Returns a list of patients' appointment
     *
     * @param String: Name must be exact
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
     * @param Doctor: Staff with staff ID filled in
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
            preparedStatement = connect.prepareStatement("select serialNumber, date, time from appointment where doctorID  = ? and patientID IS NULL");
            preparedStatement.setInt(1, docID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Appointment appt = new Appointment();
                appt.setDate(rs.getString("date"));
                appt.setTime(rs.getString("time"));
                appt.setDoctorID(docID);
                appt.setAppointmentID(rs.getInt("serialNumber"));
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

        }
    }
}

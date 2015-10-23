package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.appointments.Appointment;
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
     * @param readMe Appointment Object to select information from database
     * @return readMe
     */
    public static List<Appointment> viewAppointmentDoctor(Appointment readMe) {
        List<Appointment> a1 = null;

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID FROM appointment where doctorID = ?");
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



    public static List<Appointment> viewAppointmentPatient(Appointment readMe) {
        List<Appointment>  a1 = null;

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getDoctorID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID FROM appointment where staffID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            do {


                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int docID = resultSet.getInt("doctorID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                    readMe.setDate(date);
                    readMe.setTime(time);
                    readMe.setReason(reason);
                    readMe.setPatientID(docID);

                    a1.add(readMe);

                }
                while (resultSet.next()) ;
            }
          catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
            return a1;

    }

    /**
     *
     * @param readMe Appointment Object to extract appointment info and update database
     * @return
     */
    public static Appointment editAppointmentDoctor(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int patID = readMe.getPatientID();
            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                    + " date = ?, time = ?, reason = ?, patientID = ? WHERE doctorID = ? ;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,reason);
            preparedStatement.setInt(4, patID);
            preparedStatement.setInt(5,docID);

            checker = preparedStatement.executeUpdate();
            System.out.println("checker for doctor=============="+checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                String insertApp = "INSERT INTO appointment "
                        + "(date, time, reason, doctorID, patientID) VALUES"
                        + "(?,?,?,?,?);";
                // PreparedStatements can use variables and are more efficient
                preparedStatement = connect.prepareStatement(insertApp);
                preparedStatement.setString(1, date);
                preparedStatement.setString(2,time);
                preparedStatement.setString(3,reason);
                preparedStatement.setInt(4, docID);
                preparedStatement.setInt(5, patID);
                preparedStatement.executeUpdate();
            }

        }
        catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        }
        return readMe;
    }

    /**
     *
     * @param readMe Appointment Object to extract appointment info and update database
     * @return Appointment Object
     */
    public static Appointment editAppointmentPatient(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int patID = readMe.getPatientID();
            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                                 + " date = ?, time = ?, reason = ?, doctorID = ? WHERE patientID = ? ;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2,time);
            preparedStatement.setString(3,reason);
            preparedStatement.setInt(4, docID);
            preparedStatement.setInt(5,patID);

            checker = preparedStatement.executeUpdate();
            System.out.println("checker for patient=============="+checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                String insertApp = "INSERT INTO appointment "
                        + "(date, time, reason, doctorID, patientID) VALUES"
                        + "(?,?,?,?,?);";
                // PreparedStatements can use variables and are more efficient
                preparedStatement = connect.prepareStatement(insertApp);
                preparedStatement.setString(1, date);
                preparedStatement.setString(2,time);
                preparedStatement.setString(3,reason);
                preparedStatement.setInt(4, docID);
                preparedStatement.setInt(5,patID);
                preparedStatement.executeUpdate();
            }

        }
        catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        }
        return readMe;
    }
    /**
     * Returns a list of patients
     * @param String: Find people
     * @return ArrayList: Arraylist of Patient objects
     */
    public static ArrayList<Appointment> getPatientsAppointment(String patientName) {

        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("select userID from person where name = ?");
            preparedStatement.setString(1,patientName);
            ResultSet rs2 = preparedStatement.executeQuery();
            if(rs2.next()) {
                int patientID = rs2.getInt("userID");


                preparedStatement = connect.prepareStatement("select date, time, reason, doctorID, patientID from appointment where patientID = " + patientID);
                //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Appointment appt = new Appointment();
                    appt.setDate(rs.getString("date"));
                    appt.setTime(rs.getString("time"));
                    appt.setReason(rs.getString("reason"));
                    appt.setDoctorID(rs.getInt("doctorID"));
                    appt.setPatientID(rs.getInt("patientID"));
                    apptList.add(appt);
                }
            }
            else
            {
                System.out.println("\nName not found.");
                apptList =null;
            }
        } catch (Exception e) {
            System.out.println(e);
            apptList = null;
        } finally {
            close();
        }
        return apptList;
    }

    /** Returns a list of patients
    * @param Staff: Staff with patient ID filled in
    * @return ArrayList: Arraylist of Patient objects
    */
    public static ArrayList<Appointment> getDoctorAppointment(Staff staff) {
        //TODO: getPatientList implementation
        return null;
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

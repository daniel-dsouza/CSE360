package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.appointments.Appointment;

import java.sql.*;

public class AppointmentViewEdit {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     *
     * @param readMe Appointment Object to select information from database
     * @return readMe
     */
    public static Appointment viewAppointmentDoctor(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID FROM appointment where doctorID = ?");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String reason = resultSet.getString("reason");
            int patID = resultSet.getInt("patientID");
            if (date != "null" &&  time != "null" && reason != "null" && patID != 0) {
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Patient ID:\t" + patID);*///debugging

                readMe.setDate(date);
                readMe.setTime(time);
                readMe.setReason(reason);
                readMe.setPatientID(patID);
            }
            else
            {
                System.out.println("===========EMPTY RESULT========RETURN NULL");
                readMe = null;
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e.getStackTrace().toString());
            readMe = null;
        } finally {
            close();
        }
        return readMe;

    }

    /**
     *
     * @param readMe Appointment Object to select information from database
     * @return
     */
    public static Appointment viewAppointmentPatient(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID FROM appointment where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String reason = resultSet.getString("reason");
            int docID = resultSet.getInt("doctorID");
            if (date != "null" &&  "time" != "null" && reason != "null" && patID != 0) {
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                readMe.setDate(date);
                readMe.setTime(time);
                readMe.setReason(reason);
                readMe.setPatientID(docID);
            }
            else
            {
                System.out.println("===========EMPTY RESULT========RETURN NULL");
                readMe = null;
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e.getStackTrace().toString());
            readMe = null;
        } finally {
            close();
        }
        return readMe;

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
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

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
            System.out.println(e.getStackTrace().toString());
            readMe = null;
        }
        return readMe;
    }

    /**
     *
     * @param readMe Appointment Object to extract appointment info and update database
     * @return
     */
    public static Appointment editAppointmentPatient(Appointment readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

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
            System.out.println(e.getStackTrace().toString());
            readMe = null;
        }
        return readMe;
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

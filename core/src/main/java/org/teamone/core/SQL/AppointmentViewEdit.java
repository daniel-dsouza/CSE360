package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */
import org.teamone.core.Appointments;
import org.teamone.core.Patient;
import org.teamone.core.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppointmentViewEdit {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static Appointments viewAppointmentDoctor(Appointments readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();

            preparedStatement = connect.prepareStatement("SELECT 'date', 'time', 'reason', patientID FROM appointment where doctorID = ?");
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
    public static Appointments viewAppointmentPatient(Appointments readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT 'date', 'time', 'reason', doctorID FROM appointment where patientID = ?");
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
    public static Appointments editAppointmentDoctor(Appointments readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("UPDATE appointment SET date = " + date + ", time = " + time + ", reason = " + reason + "WHERE doctorID = " + docID);
            checker = preparedStatement.executeUpdate();
            System.out.println("checker1=============="+checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                preparedStatement = connect.prepareStatement("INSERT INTO appointment (date, time, reason, doctorID) VALUES (" + date + ", " + time + ", " + reason + ", " + docID);
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
    public static Appointments editAppointmentPatient(Appointments readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            int patID = readMe.getPatientID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("UPDATE appointment SET date = " + date + ", time = " + time + ", reason = " + reason + "WHERE patientID = " + patID);
            checker = preparedStatement.executeUpdate();
            System.out.println("checker1=============="+checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                preparedStatement = connect.prepareStatement("INSERT INTO appointment (date, time, reason, doctorID) VALUES (" + date + ", " + time + ", " + reason + ", " + patID);
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

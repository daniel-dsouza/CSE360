package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.sql.*;
import java.util.ArrayList;


public class PrescriptionSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     *
     * @param patient: Prescription to be added.
     * @return true or false: True if insert into SQL success. false otherwise
     */
    public static Boolean addPrescription(Prescription patient) {
        //only use INSERT sql.
        boolean boolResult;
        String temp = null;

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            //String mh = patient.toString();
            patient.convertDate();
            preparedStatement = connect.prepareStatement("INSERT into prescription set patientID = ?, staffID = ?, type = ?, date = ?, quantity = ?");

            preparedStatement.setInt(1, patient.getPatientID());
            preparedStatement.setInt(2, patient.getStaffID());
            preparedStatement.setString(3, patient.getPrescriptionType());
            preparedStatement.setString(4, patient.getStrDateAndTime());
            preparedStatement.setString(5, patient.getQuantity());
            checker = preparedStatement.executeUpdate();

            if (checker == 0)
                boolResult = false;
            else
                boolResult = true;

        } catch (Exception e) {
            System.out.println(e);
            boolResult = false;
        } finally {
            close();
        }
        return boolResult;
    }

    /**
     *
     * @param patient: given a patient with a valid patientID.
     * @return ArrayList of Prescriptions corresponding to Patient
     */
    public static ArrayList<Prescription> getListPrescription(Patient patient) {

        ArrayList<Prescription> PrescriptionList = new ArrayList<Prescription>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int patientID = patient.getUserID();

            preparedStatement = connect.prepareStatement("SELECT serialNumber, staffID, type, date, quantity  FROM prescription WHERE patientID = ?");
            preparedStatement.setInt(1, patientID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Prescription a = new Prescription();
                a.setPrescriptionID(resultSet.getInt("serialNumber"));
                a.setPatientID(patientID);
                a.setStaffID(resultSet.getInt("staffID"));
                a.setPrescriptionType(resultSet.getString("type"));
                a.setStrDateAndTime(resultSet.getString("date"));
                a.setQuantity(resultSet.getString("quantity"));

                PrescriptionList.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
            PrescriptionList = null;
        } finally {
            close();
        }
        return PrescriptionList;
    }

    /**
     *
     * Gets everything from prescriptions
     * @return ArrayList of Prescriptions corresponding to Patient
     */
    public static ArrayList<Prescription> getAllPrescriptions() {

        ArrayList<Prescription> PrescriptionList = new ArrayList<Prescription>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT serialNumber, staffID, type, date, quantity, patientID  FROM prescription");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Prescription a = new Prescription();
                a.setPrescriptionID(resultSet.getInt("serialNumber"));
                a.setPatientID(resultSet.getInt("patientID"));
                a.setStaffID(resultSet.getInt("staffID"));
                a.setPrescriptionType(resultSet.getString("type"));
                a.setStrDateAndTime(resultSet.getString("date"));
                a.setQuantity(resultSet.getString("quantity"));

                PrescriptionList.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
            PrescriptionList = null;
        } finally {
            close();
        }
        return PrescriptionList;
    }

    /**
     * Given a valid staffID, date, type, patientID and quantity, return ID
     *
     * @param readMe: Prescription given a patient with a valid staffID, date, type, patientID and quantity,.
     * @return Prescriptions with ID corresponding to Patient
     */
    public static Prescription getPrescriptionID(Prescription readMe) {

        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int staffID = readMe.getStaffID();
            int patID = readMe.getPatientID();
            String date = readMe.getStrDateAndTime();
            String type = readMe.getPrescriptionType();
            String quantity = readMe.getQuantity();

            preparedStatement = connect.prepareStatement("SELECT serialNumber FROM prescription where staffID = ? and date = ? and type = ? and patientID = ? and quantity = ?");
            preparedStatement.setInt(1, staffID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, patID);
            preparedStatement.setString(5, quantity);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            readMe.setPrescriptionID(resultSet.getInt("serialNumber"));

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
     *
     * @param readMe: Prescription given a patient with a valid serialnumber
     * @return Prescription object
     */
    public static Prescription viewPrescriptonByID(Prescription readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int presID = readMe.getPrescriptionID();

            preparedStatement = connect.prepareStatement("SELECT date, type, quantity, staffID, patientID FROM prescription where serialNumber = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, presID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set


            String date = resultSet.getString("date");
            String type = resultSet.getString("type");
            String quantity = resultSet.getString("quantity");
            int staffID = resultSet.getInt("staffID");
            int patID = resultSet.getInt("patientID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Type:\t" + type);
                System.out.println("Quantity:\t" + quantity);
                System.out.println("StaffID:\t" + staffID);
                System.out.println("PatientID:\t" + patID);*///debugging
            Patient temp = new Patient();
            temp.setUserID(patID);
            //temp = PatientSQL.getPatientComplete(temp);
            readMe.setPatient(temp);

            Doctor temp1 = new Doctor();
            temp1.setUserID(staffID);
            readMe.setDoctor(temp1);

            readMe.setStrDateAndTime(date);
            readMe.setPrescriptionType(type);
            readMe.setQuantity(quantity);
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

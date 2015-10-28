package org.teamone.core.SQL;

import org.teamone.core.labs.LabTest;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2015.
 * ONLY LAB TESTS OBJECTS OR ARRAYLISTS
 */
public class LabTestSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    /**
     *
     * @param LabTest with valid RequestionID and patient ID
     * @return
     */
    public static LabTest updateLabTest(LabTest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int patID = readMe.getPatient().getUserID();
            String labReport = readMe.toString();
            String dateString = readMe.getDate();


            String updateLab = "UPDATE labtest SET"
                    + " labType = ?, labReport = ?, date = ? WHERE patientID = ? and serialNumber = ? ;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(updateLab);
            preparedStatement.setString(1, "labReport");
            preparedStatement.setString(2, labReport);
            preparedStatement.setString(3, dateString);
            preparedStatement.setInt(4, patID);
            preparedStatement.setInt(5, readMe.getRequestionID());

            checker = preparedStatement.executeUpdate();


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
     * @param LabTest: Valid LabTest with a requestionID
     * @return LabTest: returns a LabTest object
     */
    public static LabTest viewLabTestByRequestion(LabTest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int reqID = readMe.getRequestionID();

            preparedStatement = connect.prepareStatement("SELECT labReport, date, patientID, staffID FROM labtest where serialNumber = ? and labType = ?");
            preparedStatement.setInt(1, reqID);
            preparedStatement.setString(2, "labReport");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            String labReport = resultSet.getString("labReport");
            String date = resultSet.getString("date");
            int patID = resultSet.getInt("patientID");
            int stafID = resultSet.getInt("staffID");

            if (!date.equals("null") &&  !labReport.equals(null)) {
                readMe.setDate(date);
                readMe.toMapObj(labReport);
                readMe.getPatient().setUserID(patID);
                readMe.getPerson().setUserID(stafID);
            }
            else
            {
                System.out.println("===========EMPTY RESULT========RETURN NULL");
                readMe = null;
            }
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
     * Gets everything from table labtests
     * @return ArrayList: list of LabTests
     */
    public static ArrayList<LabTest> getAllLabTests() {
        ArrayList<LabTest> LabTestList = new ArrayList<LabTest>();

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient


            preparedStatement = connect.prepareStatement("SELECT serialNumber, labReport, date, patientID, staffID FROM labtest where labType = ?");
            preparedStatement.setString(1, "labReport");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LabTest new1 = new LabTest();
                new1.setRequestionID(resultSet.getInt("serialNumber"));
                new1.toMapObj(resultSet.getString("labReport"));
                Patient pat = new Patient();
                pat.setUserID(resultSet.getInt("patientID"));
                Staff sta = new Staff();
                sta.setUserID(resultSet.getInt("staffID"));
                LabTestList.add(new1);
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            LabTestList = null;
        } finally {
            close();
        }
        return LabTestList;

    }
    /**
     *
     * @param LabTest: LabTest with valid patient ID
     * @return LabTest object
     */
    public static LabTest viewLabTest(LabTest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatient().getUserID();

            preparedStatement = connect.prepareStatement("SELECT labReport, date FROM labtest where patientID = ? and labType = ?");
            preparedStatement.setInt(1, patID);
            preparedStatement.setString(2, "labReport");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            String labReport = resultSet.getString("labReport");
            String date = resultSet.getString("date");
            if (!date.equals("null") &&  !labReport.equals(null)) {

                readMe.setDate(date);
                readMe.toMapObj(labReport);
            }
            else
            {
                System.out.println("===========EMPTY RESULT========RETURN NULL");
                readMe = null;
            }
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
     * @param Patient p: given a patient with a valid patientID.
     * @return ArrayList of LabTests corresponding to Patient
     */

    public static ArrayList<LabTest> getListLabTestByPatient(Patient p) {

        ArrayList<LabTest> LabTestList = new ArrayList<LabTest>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int patID = p.getUserID();
            preparedStatement = connect.prepareStatement("SELECT labReport, date, serialNumber FROM labtest where patientID = ? and labType = ?;");
            preparedStatement.setInt(1, patID);
            preparedStatement.setString(2, "labReport");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LabTest a = new LabTest();
                Patient pat = new Patient();
                pat.setUserID(patID);
                a.setDate(resultSet.getString("date"));
                a.toMapObj(resultSet.getString("labReport"));
                a.setRequestionID(resultSet.getInt("serialNumber"));
                LabTestList.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
            LabTestList = null;
        } finally {
            close();
        }
        return LabTestList;
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

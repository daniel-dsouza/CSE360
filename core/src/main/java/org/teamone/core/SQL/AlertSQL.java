package org.teamone.core.SQL;

import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2015.
 */
public class AlertSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * This is will set alert to be false
     * @param alert: Alert with valid alertID.
     * @return true or false
     */
    public static Boolean setAlertOff(Alert alert) {
        boolean boolResult;

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int alertID = alert.getAlertID();

            preparedStatement = connect.prepareStatement("UPDATE alerts set AlertActive = false where alert_id = ?");
            preparedStatement.setInt(1, alertID);
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
     * @return Boolean. true if there is atleast 1 alert. false if none
     */
    public static Boolean areThereAlerts() {

        Boolean result = false;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            if(resultSet.first())//if Resultset does exist,
            {
                result = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        } finally {
            close();
        }
        return result;
    }

    /**
     * get list of alerts
     * @return arraylist
     */
    public static ArrayList<Alert> getListAlerts() {

        ArrayList<Alert> alertList = new ArrayList<Alert>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id,  alert_reason,  doctor_id,  patient_id, alertDateAndTime  FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alert a = new Alert();
                a.setAlertID(resultSet.getInt("alert_id"));
                a.setReason(resultSet.getString("alert_reason"));
                a.setDoctorID(resultSet.getInt("doctor_id"));
                a.setPatientID(resultSet.getInt("patient_id"));
                a.setAlertDateAndTime(resultSet.getString("alertDateAndTime"));
                a.setAlertStatus(true);
                alertList.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
            alertList = null;
        } finally {
            close();
        }
        return alertList;
    }

    /**
     * get list of alerts by patient ID
     *
     * @param pat1 patient object with a valid ID.
     * @return arraylist
     */
    public static ArrayList<Alert> getListAlertsByPatient(Patient pat1) {

        ArrayList<Alert> alertList = new ArrayList<Alert>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int patID = pat1.getUserID();

            preparedStatement = connect.prepareStatement("SELECT alert_id,  alert_reason,  doctor_id,  alertDateAndTime  FROM alerts WHERE AlertActive = 1 and patient_id = ?;");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alert a = new Alert();
                a.setAlertID(resultSet.getInt("alert_id"));
                a.setReason(resultSet.getString("alert_reason"));
                a.setDoctorID(resultSet.getInt("doctor_id"));
                a.setPatientID(patID);
                a.setAlertDateAndTime(resultSet.getString("alertDateAndTime"));
                a.setAlertStatus(true);
                alertList.add(a);
            }

        } catch (Exception e) {
            System.out.println(e);
            alertList = null;
        } finally {
            close();
        }
        return alertList;
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

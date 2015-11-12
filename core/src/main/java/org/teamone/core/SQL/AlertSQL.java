package org.teamone.core.SQL;

import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2015.
 */
public class AlertSQL {


    /***
     * Checks if alerts exist in a timespan of 2 min
     *
     * @param time1 takes the alertDateAndTime of an alert
     * @return True if the alert's time is within 5 minutes of the time.
     */
    public static Boolean isTimeWithin5Min(String time1) {

        java.util.Date dateToday = new java.util.Date();
        java.util.Date appointmentDate = new java.util.Date();
        SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");

        int positionDate = 0;
        positionDate = time1.indexOf(" ");

        String date = time1.substring(0, positionDate);

        try {

            java.util.Date temp = new java.util.Date();
            String todayStr = convertToDate.format(temp);

            dateToday = convertToDate.parse(todayStr);
            appointmentDate = convertToDate.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appointmentDate.compareTo(dateToday) == 0) {
            SimpleDateFormat convertToTime = new SimpleDateFormat("HH:mm:ss");

            java.util.Date alertTime = new java.util.Date();
            java.util.Date currentTime = new java.util.Date();

            java.util.Date tenMin = new java.util.Date(System.currentTimeMillis() - 10 * 60 * 1000);
            String tenMinStr = "";
            String cTime = "";
            String time = "";
            int positionTime = 0;
            positionTime = 1 + time1.indexOf(" ");

            time = time1.substring(positionTime);
            cTime = convertToTime.format(currentTime);
            tenMinStr = convertToTime.format(tenMin);

            //System.out.println("alert Time: " + time + "\ncurrent Time: " + cTime + "\nfive minutes from now: " + tenMinStr);

            try {
                alertTime = convertToTime.parse(time);
                currentTime = convertToTime.parse(cTime);
                tenMin = convertToTime.parse(tenMinStr);

            } catch (Exception e) {
                e.printStackTrace();
            }

            if (alertTime.compareTo(currentTime) <= 0 && alertTime.compareTo(tenMin) >= 0)
                return true;
            else
                return false;

        } else return false;
    }


    /**
     * This is will set alert to be false
     *
     * @param alert: Alert with valid alertID.
     * @return true or false
     */
    public static Boolean setAlertOff(Alert alert) {
        boolean boolResult;
        Connection connect = null;
        PreparedStatement preparedStatement = null;
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

            boolResult = checker != 0;

        } catch (Exception e) {
            System.out.println(e);
            boolResult = false;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return boolResult;
    }

    /**
     * @return Boolean. true if there is atleast 1 alert. false if none
     */
    public static Boolean areThereAlerts() {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Boolean result = false;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first())//if Resultset does exist,
            {
                result = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        } finally {
            try {
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {

            }
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }

    /**
     * get list of alerts
     *
     * @return arraylist
     */
    public static ArrayList<Alert> getListAlerts() {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return alertList;
    }

    /**
     * get list of alerts within a 5min range
     *
     * @return arraylist
     */
    public static ArrayList<Alert> getListAlertsPopUp() {
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Alert> alertList = new ArrayList<Alert>();

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id,  alert_reason,  doctor_id,  patient_id, alertDateAndTime  FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first())//atleast one alert
            {
                do {
                    String alertTime = resultSet.getString("alertDateAndTime");
                    //System.out.println("Alert ID:" + resultSet.getInt("alert_id"));
                    if (isTimeWithin5Min(alertTime)) {
                        Alert a = new Alert();
                        a.setAlertID(resultSet.getInt("alert_id"));
                        a.setReason(resultSet.getString("alert_reason"));
                        a.setDoctorID(resultSet.getInt("doctor_id"));
                        a.setPatientID(resultSet.getInt("patient_id"));
                        a.setAlertDateAndTime(alertTime);
                        a.setAlertStatus(true);

                        alertList.add(a);
                    }
                } while (resultSet.next());
            }
            if (alertList.size() == 0) {
                alertList = null;

            }

        } catch (Exception e) {
            System.out.println(e);
            alertList = null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
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
        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
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
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return alertList;
    }
}

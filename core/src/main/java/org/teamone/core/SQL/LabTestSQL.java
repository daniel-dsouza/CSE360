package org.teamone.core.SQL;

import org.teamone.core.labs.LabTest;
import org.teamone.core.users.Patient;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2015.
 */
public class LabTestSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static LabTest viewLabTest(LabTest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT labType, labReport, date FROM labtest where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            String labType = resultSet.getString("labType");
            String labReport = resultSet.getString("labReport");
            String date = resultSet.getString("date");
            if (!date.equals("null") &&  !labReport.equals(null) && !labType.equals("null") && patID != 0) {
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                readMe.setStrDateAndTime(date);
                readMe.setLabReport(labReport);
                readMe.setTestType(labType);
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

    public static ArrayList<LabTest> getListLabTest(Patient p) {

        ArrayList<LabTest> LabTestList = new ArrayList<LabTest>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id,  alert_reason,  doctor_id,  patient_id, alertDateAndTime  FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LabTest a = new LabTest();
               /* a.setAlertID(resultSet.getInt("alert_id"));
                a.setReason(resultSet.getString("alert_reason"));
                a.setDoctorID(resultSet.getInt("doctor_id"));
                a.setPatientID(resultSet.getInt("patient_id"));
                a.setAlertDateAndTime(resultSet.getString("alertDateAndTime"));
                a.setAlertStatus(true);*/
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

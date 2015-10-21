package org.teamone.core.SQL;

import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Patient;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/21/2015.
 */
public class DoctorSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     *
     * @param Prescription patient: Prescription to be added.
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
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String mh = patient.toString();

            preparedStatement = connect.prepareStatement("UPDATE patient set medicalHistory = ? where patientID = ?");

            preparedStatement.setString(1, mh);
            preparedStatement.setInt(2, ID);
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
     * @param Patient p: given a patient with a valid patientID.
     * @return ArrayList of Prescriptions corresponding to Patient
     */
    public static ArrayList<Prescription> getListPrescription(Patient p) {

        ArrayList<Prescription> PrescriptionList = new ArrayList<Prescription>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("SELECT alert_id,  alert_reason,  doctor_id,  patient_id, alertDateAndTime  FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Prescription a = new Prescription();
               /* a.setAlertID(resultSet.getInt("alert_id"));
                a.setReason(resultSet.getString("alert_reason"));
                a.setDoctorID(resultSet.getInt("doctor_id"));
                a.setPatientID(resultSet.getInt("patient_id"));
                a.setAlertDateAndTime(resultSet.getString("alertDateAndTime"));
                a.setAlertStatus(true);*/
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

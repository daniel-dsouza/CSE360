package org.teamone.core.SQL;

import org.teamone.core.labs.LabTest;

import java.sql.*;

/**
 * Created by Stephanie on 10/21/15
 */

public class LabStaffSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static LabTest updateLabTest(LabTest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int patID = readMe.getPatient().getPatientID();
            String labReport = readMe.toString();
            String dateString = readMe.getDate();


            String updateLab = "UPDATE labtest SET"
                    + " labReport = ?, date = ? WHERE patientID = ? ;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(updateLab);
            preparedStatement.setString(1,labReport);
            preparedStatement.setString(2, dateString);
            preparedStatement.setInt(3, patID);

            checker = preparedStatement.executeUpdate();
            System.out.println("checker for doctor=============="+checker);
            //If no data was manipulated insert new appointment
            if (checker == 0) {
                String insertApp = "INSERT INTO labtest"
                        + "(patientID, labReport, date) VALUES"
                        + "(?,?,?,?);";
                // PreparedStatements can use variables and are more efficient
                preparedStatement = connect.prepareStatement(insertApp);
                preparedStatement.setInt(1, patID);
                preparedStatement.setString(2,labReport);
                preparedStatement.setString(3, dateString);
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


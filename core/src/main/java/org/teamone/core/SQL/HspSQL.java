package org.teamone.core.SQL;

import org.teamone.core.users.Patient;

import java.sql.*;

/**
 * Created by Lin on 2015/10/8.
 */



public class HspSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatementPatient = null;
    private static PreparedStatement preparedStatementPerson = null;
    private static ResultSet resultSet = null;

    public static boolean RegisterNewPatient(Patient patient)
    { boolean boolResult;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int userID = patient.getUserID();
            int patientID = patient.getPatientID();
            String name = patient.getName();
            String SSN = patient.getSSN();
            String address = patient.getAddress();
            String email = patient.getEmail();
            String phone = patient.getPhone();
            String insurance = patient.getInsurance();
            String age = patient.getAge();
            String gender = patient.getGender();
            String password = patient.getPassword();

            //http://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
            String insertTablePerson = "INSERT INTO person"
                    + "(userID, name, occupation, password, emailID) VALUES"
                    + "(?,?,?,?,?)";

            preparedStatementPerson = connect.prepareStatement(insertTablePerson);
            preparedStatementPerson.setInt(1, userID);
            preparedStatementPerson.setString(2,name);
            preparedStatementPerson.setString(3,"patient");
            preparedStatementPerson.setString(4,password);
            preparedStatementPerson.setString(5,email);

            //INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES (1232, 'Ry;an', 'doctor', 'temporary', 'ryan@asu.edu');
            checker2 = preparedStatementPerson.executeUpdate();
            String insertTablePatient = "INSERT INTO patient"
                    + "(patientID, occupation, address, SSN, gender, insurance, age, phone) VALUES"
                    + "(?,?,?,?,?,?,?,?)";

            preparedStatementPatient = connect.prepareStatement(insertTablePatient);

            //`serialNumber`, `patientID`, `medicalHistory`, `occupation`, `address`, `SSN`, `gender`, `insurance`, `age`, `phone`, `healthConditions`, `labReports`, `alertDateAndTime`, `alertStatus`, `prescription`

            preparedStatementPatient.setInt(1, patientID);
            preparedStatementPatient.setString(2, "patient");
            preparedStatementPatient.setString(3, address);
            preparedStatementPatient.setString(4, SSN);
            preparedStatementPatient.setString(5, gender);
            preparedStatementPatient.setString(6, insurance);
            preparedStatementPatient.setString(7, age);
            preparedStatementPatient.setString(8, phone);
            checker = preparedStatementPatient.executeUpdate();

            System.out.println("checker1=============="+checker);
            System.out.println("checker2=============="+checker2);

            if (checker==0 | checker2==0)
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

        }
    }

}

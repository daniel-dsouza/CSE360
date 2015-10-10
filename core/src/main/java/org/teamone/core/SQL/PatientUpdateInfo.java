package org.teamone.core.SQL;

import org.teamone.core.Patient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Lin on 2015/10/8.
 */



public class PatientUpdateInfo {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static PreparedStatement preparedStatement2 = null;
    private static ResultSet resultSet = null;

    public static boolean UpdatePersonalInfo(Patient patient)
    { boolean boolResult;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();


            // PreparedStatements can use variables and are more efficient
            int patientID = patient.getPatientID();
            String fname = patient.getfName();
            String lname = patient.getlName();
            int SSN = patient.getSSN();
            String address = patient.getAddress();
            String email = patient.getEmail();
            int phone = patient.getPhone();
            String insurance = patient.getInsurance();
            int age = patient.getAge();
            String gender = patient.getGender();

            preparedStatement = connect.prepareStatement("UPDATE patient set address = ?,phone = ?,SSN = ?,insurance = ?,age = ?,gender = ? where patientID = ?");
            preparedStatement.setString(1, address);
            preparedStatement.setInt(2, phone);
            preparedStatement.setInt(3, SSN);
            preparedStatement.setString(4, insurance);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, gender);
            preparedStatement.setInt(7, patientID);
            checker = preparedStatement.executeUpdate();

            preparedStatement2 = connect.prepareStatement("UPDATE person set emailID = ?,lName = ?,fName = ? where userID = ?");
            preparedStatement2.setString(3, fname);
            preparedStatement2.setString(2, lname);
            preparedStatement2.setInt(4, patientID);
            preparedStatement2.setString(1, email);

            checker2 = preparedStatement2.executeUpdate();

            System.out.println("checker1=============="+checker);
            System.out.println("checker2=============="+checker2);

            if (checker==0 | checker2==0)
                boolResult = false;
            else
                boolResult = true;


        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            boolResult = false;
        } finally {
            close();
        }
        return boolResult;

    }

    /* private static boolean verify(ResultSet resultSet, String pass) throws SQLException {
         // ResultSet is initially before the first data set
         resultSet.next();
         boolean boolResult;
         String passwordSQL = resultSet.getString("password");

         if(pass.compareTo(passwordSQL)==0)
         {
             boolResult = true;
         }
         else
             boolResult = false;
         return boolResult;
     }
 */
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

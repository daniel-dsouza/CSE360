package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/9/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 *
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */
import org.teamone.core.users.Patient;

import java.sql.*;

public class PatientSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static boolean updateHealthCondition(org.teamone.core.users.Patient patient) {
        boolean boolResult;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", PasswordSQL.mySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String hc = patient.getHealthConditions();

            preparedStatement = connect.prepareStatement("UPDATE patient set healthConditions = ? where patientID = ?");
            preparedStatement.setString(1,hc);
            preparedStatement.setInt(2, ID);
            checker = preparedStatement.executeUpdate();
            if (checker==0)
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

    public static boolean UpdatePersonalInfo(Patient patient)
    { boolean boolResult;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", PasswordSQL.mySQLpass);

            PreparedStatement preparedStatementPatient = null;
            PreparedStatement preparedStatementPerson = null;


            // PreparedStatements can use variables and are more efficient
            int patientID = patient.getPatientID();
            String name = patient.getName();
            String SSN = patient.getSSN();
            String address = patient.getAddress();
            String email = patient.getEmail();
            String phone = patient.getPhone();
            String insurance = patient.getInsurance();
            String age = patient.getAge();
            String gender = patient.getGender();

            preparedStatementPatient = connect.prepareStatement("UPDATE patient set address = ?,phone = ?,SSN = ?,insurance = ?,age = ?,gender = ? where patientID = ? ;");
            preparedStatementPatient.setString(1, address);
            preparedStatementPatient.setString(2, phone);
            preparedStatementPatient.setString(3, SSN);
            preparedStatementPatient.setString(4, insurance);
            preparedStatementPatient.setString(5, age);
            preparedStatementPatient.setString(6, gender);
            preparedStatementPatient.setInt(7, patientID);
            checker = preparedStatementPatient.executeUpdate();

            preparedStatementPerson = connect.prepareStatement("UPDATE person set emailID = ?,name = ? where userID = ? ;");
            preparedStatementPerson.setString(2, name);
            preparedStatementPerson.setInt(3, patientID);
            preparedStatementPerson.setString(1, email);

            checker2 = preparedStatementPerson.executeUpdate();

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
            System.out.println(e);
        }
    }

}

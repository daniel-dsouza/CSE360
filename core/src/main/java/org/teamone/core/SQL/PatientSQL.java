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

    public static boolean updateHealthCondition(Patient patient) {
        boolean boolResult;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String hc = patient.getHealthConditions();

            preparedStatement = connect.prepareStatement("UPDATE patient set healthConditions = ? where patientID = ?");
            preparedStatement.setString(1, hc);
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

    public static boolean UpdatePersonalInfo(Patient patient) {
        boolean boolResult;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

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

            System.out.println("checker1==============" + checker);
            System.out.println("checker2==============" + checker2);

            if (checker == 0 | checker2 == 0)
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

    public static Patient getMedicalHistory(Patient patient) {
        Patient medicalHistory = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String mh = null;

            preparedStatement = connect.prepareStatement("SELECT medicalhistory FROM patient where patientID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            mh = resultSet.getString("medicalhistory");
            patient.setMedicalHistory(mh);
            patient.setPatientID(ID);
            temp = mh;
            patient.medicalHistory.toMapObj(temp);

        } catch (Exception e) {
            System.out.println(e);
            patient = null;
        } finally {
            close();
        }

        return patient;

    }

    public static Boolean setMedicalHistory(Patient patient) {
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
            String mh = patient.medicalHistory.toString();

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


    public static Patient getHealthConditions(Patient patient) {
        Patient healthConditions = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String hc = null;

            preparedStatement = connect.prepareStatement("SELECT healthConditions FROM patient where patientID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            hc = resultSet.getString("healthConditions");
            patient.setHealthConditions(hc);
            patient.setPatientID(ID);
            temp = hc;
            patient.healthConditions.toMapObj(temp);

        } catch (Exception e) {
            System.out.println(e);
            patient = null;
        } finally {
            close();
        }

        return patient;

    }

    public static Boolean setHealthConditions(Patient patient) {
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
            String hc = patient.healthConditions.toString();

            preparedStatement = connect.prepareStatement("UPDATE patient set healthConditions = ? where patientID = ?");

            preparedStatement.setString(1, hc);
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
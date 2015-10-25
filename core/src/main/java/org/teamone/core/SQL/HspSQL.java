package org.teamone.core.SQL;

import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Lin on 2015/10/8.
 */



public class HspSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatementPatient = null;
    private static PreparedStatement preparedStatementPerson = null;
    private static ResultSet resultSet = null;

    public static Patient RegisterNewPatient(Patient patient)
    { Patient Result;
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int userID = patient.getUserID();

            String name = patient.patientInformation.toStringName();
            String SSN = patient.getSSN();
            String address = patient.patientInformation.toStringAddress();
            String email = patient.patientInformation.getEmail();
            String phone = patient.getPhone();
            String insurance = patient.getInsurance();
            String age = patient.getAge();
            String gender = patient.getGender();
            String password = patient.getPassword();

            //http://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
            String insertTablePerson = "INSERT INTO person"
                    + "( name, occupation, password, emailID) VALUES"
                    + "(?,?,?,?)";

            preparedStatementPerson = connect.prepareStatement(insertTablePerson);
            preparedStatementPerson.setString(1, name);
            preparedStatementPerson.setString(2,"patient");
            preparedStatementPerson.setString(3,"go");
            preparedStatementPerson.setString(4,email);
            checker2 = preparedStatementPerson.executeUpdate();

            preparedStatementPerson = connect.prepareStatement("SELECT userID FROM person WHERE name = ? AND occupation = ? AND password = ? AND emailID = ?");
            preparedStatementPerson.setString(1, name);
            preparedStatementPerson.setString(2,"patient");
            preparedStatementPerson.setString(3,"go");
            preparedStatementPerson.setString(4,email);
            resultSet = preparedStatementPerson.executeQuery();
            resultSet.next();
            int patientID = resultSet.getInt("userID");
            //INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES (1232, 'Ry;an', 'doctor', 'temporary', 'ryan@asu.edu');

            String insertTablePatient = "INSERT INTO patient"
                    + "(patientID, occupation, address, SSN, gender, insurance, age, phone, medicalHistory, healthConditions) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?)";

            preparedStatementPatient = connect.prepareStatement(insertTablePatient);

            //`serialNumber`, `patientID`, `medicalHistory`, `occupation`, `address`, `SSN`, `gender`, `insurance`, `age`, `phone`, `healthConditions`, `labReports`, `alertDateAndTime`, `alertStatus`, `prescriptions`

            preparedStatementPatient.setInt(1, patientID);
            preparedStatementPatient.setString(2, "patient");
            preparedStatementPatient.setString(3, address);
            preparedStatementPatient.setString(4, SSN);
            preparedStatementPatient.setString(5, gender);
            preparedStatementPatient.setString(6, insurance);
            preparedStatementPatient.setString(7, age);
            preparedStatementPatient.setString(8, phone);
            preparedStatementPatient.setString(9, patient.healthConditions.toString());
            preparedStatementPatient.setString(10, patient.medicalHistory.toString());
            checker = preparedStatementPatient.executeUpdate();

            System.out.println("checker1=============="+checker);
            System.out.println("checker2=============="+checker2);
            System.out.println("Adding info into Patient obj");

            Result = new Patient();
            Result.setOccupation("patient");
            Result.setName(name);
            Result.setPatientID(patientID);
            Result.setEmail(email);

            Result.setAddress(address);
            Result.setSSN(SSN);
            Result.setGender(gender);
            Result.setInsurance(insurance);
            Result.setAge(age);
            Result.setPhone(phone);

            if (checker==0 | checker2==0)
                Result = null;



        } catch (Exception e) {
            System.out.println(e);
            Result = null;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Extracts all persons in Person table
     * @return ArrayList: of all persons
     */
    public static ArrayList<Person> revealAll() {

        ArrayList<Person> adminList = new ArrayList<Person>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatementPatient = connect.prepareStatement("select userID, name, occupation, password, emailID from person ;");
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            ResultSet rs = preparedStatementPatient.executeQuery();

            while (rs.next()) {
                Person pers = new Person();
                pers.setUserID((rs.getInt("userID")));
                pers.setName(rs.getString("name"));
                pers.setOccupation(rs.getString("occupation"));
                pers.setPassword(rs.getString("password"));
                pers.setEmail(rs.getString("emailID"));
                adminList.add(pers);
            }

        } catch (Exception e) {
            System.out.println(e);
            adminList = null;

        } finally {
            close();
        }
        return adminList;
    }
    /**
     * Deletes all persons in Person table with id above 1001. ids from 1001 to 1999 are reserved for patients.
     * @return ArrayList: of all persons with id>1001
     */
    public static ArrayList<Person> deletePatients() {

        ArrayList<Person> adminList = new ArrayList<Person>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatementPatient = connect.prepareStatement("select userID, name, occupation, password, emailID from person where userID > 1001;");
            ResultSet rs = preparedStatementPatient.executeQuery();
            preparedStatementPatient = connect.prepareStatement("delete from person where userID > 1001;");
            int checker = preparedStatementPatient.executeUpdate();

            while (rs.next()) {
                Person pers = new Person();
                pers.setUserID((rs.getInt("userID")));
                pers.setName(rs.getString("name"));
                pers.setOccupation(rs.getString("occupation"));
                pers.setPassword(rs.getString("password"));
                pers.setEmail(rs.getString("emailID"));
                adminList.add(pers);
            }
            if(checker ==0) {
                System.out.println("Delete failed");
                adminList = null;
            }
            else
                System.out.println("Delete success");
        } catch (Exception e) {
            System.out.println(e);
            adminList = null;

        } finally {
            close();
        }
        return adminList;
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

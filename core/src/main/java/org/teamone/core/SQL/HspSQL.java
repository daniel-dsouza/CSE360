package org.teamone.core.SQL;

import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lin on 2015/10/8.
 */


public class HspSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatementPatient = null;
    private static PreparedStatement preparedStatementPerson = null;
    private static ResultSet resultSet = null;

    /**
     * DO NOT USE THIS IN FRONTEND. TESTING BACKEND ONLY
     */
    public static Patient random()//randomizer so we can loop multiple
    {
        Patient regis = new Patient();
        Random randomGenerator = new Random();

        //pick female or male name http://deron.meranda.us/data/
        String firstFile = "src/test/java/org/teamone/core/input/Female.txt";
        int femaleOrMale = randomGenerator.nextInt(500);
        if ((femaleOrMale % 2) == 0)//even
            firstFile = "src/test/java/org/teamone/core/input/Male.txt";

        String lastFile = "src/test/java/org/teamone/core/input/lastNames.txt";

        //First Name array
        ArrayList<String> firstNames = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(firstFile));
            while (in.ready()) {
                firstNames.add(in.readLine());
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //Last Name array
        ArrayList<String> lastNames = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(firstFile));
            while (in.ready()) {
                lastNames.add(in.readLine());
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);

        }

        String firstRNG = firstNames.get(randomGenerator.nextInt(firstNames.size()));
        String lastRNG = lastNames.get(randomGenerator.nextInt(lastNames.size()));
        regis.patientInformation.setFirstName(firstRNG);
        regis.patientInformation.setLastName(lastRNG);
        firstRNG += lastRNG + "@asu.edu";
        regis.patientInformation.setEmail(firstRNG);
        String random = "" + (char) (randomGenerator.nextInt(26) + 'A');
        for (int i = 0; i < 10; i++)//address
        {
            random += (char) (randomGenerator.nextInt(26) + 'a');
        }

        //Street Name array
        String streetFile = "src/test/java/org/teamone/core/input/StreetNamesTempe.txt";
        ArrayList<String> streets = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(streetFile));
            while (in.ready()) {
                streets.add(in.readLine());
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        regis.patientInformation.setAddress(streets.get(randomGenerator.nextInt(streets.size())));
        regis.patientInformation.setCity("Phoenix");
        regis.patientInformation.setState("AZ");
        random = "";
        for (int i = 0; i < 5; i++)//zipcode
        {
            random += (char) (randomGenerator.nextInt(10) + '0');
        }

        regis.patientInformation.setZipcode(random);

        random = "";
        for (int i = 0; i < 10; i++)//phone (480)-748-7374
        {
            if (i == 0)
                random += "(";
            if (i == 3)
                random += ")-";
            if (i == 6)
                random += "-";
            random += (char) (randomGenerator.nextInt(10) + '0');
        }
        regis.patientInformation.setHomePhone(random);
        random = "";
        for (int i = 0; i < 9; i++)//SSN 000-00-0000
        {
            if (i == 3)
                random += "-";
            if (i == 5)
                random += "-";
            random += (char) (randomGenerator.nextInt(10) + '0');
        }
        regis.patientInformation.setSsn(random);

        //Insurance array
        String insureFile = "src/test/java/org/teamone/core/input/Insurance.txt";
        ArrayList<String> insure = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(insureFile));
            while (in.ready()) {
                insure.add(in.readLine());
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        regis.patientInformation.setInsurance((insure.get(randomGenerator.nextInt(insure.size()))));

        int age = randomGenerator.nextInt(100);//age
        random = Integer.toString(age);
        regis.patientInformation.setAge(random);

        String gender = "Female";
        if ((femaleOrMale % 2) == 0)//even
            gender = "Male";
        regis.patientInformation.setGender(gender);

        return regis;
    }

    /**
     * Register a new patient
     *
     * @param patient
     * @return Patient
     */
    public static Patient RegisterNewPatient(Patient patient) {
        Patient Result;
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
            preparedStatementPerson.setString(2, "patient");
            preparedStatementPerson.setString(3, "go");
            preparedStatementPerson.setString(4, email);
            checker2 = preparedStatementPerson.executeUpdate();

            preparedStatementPerson = connect.prepareStatement("SELECT userID FROM person WHERE name = ? AND occupation = ? AND password = ? AND emailID = ?");
            preparedStatementPerson.setString(1, name);
            preparedStatementPerson.setString(2, "patient");
            preparedStatementPerson.setString(3, "go");
            preparedStatementPerson.setString(4, email);
            resultSet = preparedStatementPerson.executeQuery();
            resultSet.next();
            int patientID = resultSet.getInt("userID");
            //INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES (1232, 'Ry;an', 'doctor', 'temporary', 'ryan@asu.edu');

            String insertTablePatient = "INSERT INTO patient"
                    + "(patientID, occupation, address, SSN, gender, insurance, age, phone, medicalHistory, healthConditions, date) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?)";

            preparedStatementPatient = connect.prepareStatement(insertTablePatient);

            //`serialNumber`, `patientID`, `medicalHistory`, `occupation`, `address`, `SSN`, `gender`, `insurance`, `age`, `phone`, `healthConditions`, `labReports`, `alertDateAndTime`, `alertStatus`, `prescriptions`
            java.util.Date dateAndTime = new java.util.Date();
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDateAndTime = sdf.format(dateAndTime);
            preparedStatementPatient.setInt(1, patientID);
            preparedStatementPatient.setString(2, "patient");
            preparedStatementPatient.setString(3, address);
            preparedStatementPatient.setString(4, SSN);
            preparedStatementPatient.setString(5, gender);
            preparedStatementPatient.setString(6, insurance);
            preparedStatementPatient.setString(7, age);
            preparedStatementPatient.setString(8, phone);
            preparedStatementPatient.setString(9, patient.medicalHistory.toString());
            preparedStatementPatient.setString(10, patient.healthConditions.toString());
            preparedStatementPatient.setString(11, strDateAndTime);
            checker = preparedStatementPatient.executeUpdate();

            System.out.println("checker1==============" + checker);
            System.out.println("checker2==============" + checker2);
            System.out.println("Adding info into Patient obj");

            Result = new Patient();
            Result.setOccupation("patient");
            Result.setName(name);
            Result.setUserID(patientID);
            Result.setEmail(email);

            Result.setAddress(address);
            Result.setSSN(SSN);
            Result.setGender(gender);
            Result.setInsurance(insurance);
            Result.setAge(age);
            Result.setPhone(phone);

            if (checker == 0 | checker2 == 0)
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
     * Register a new patient, although this one can manually pick a date
     *
     * @param patient, date
     * @return Patient
     */
    public static Patient RegisterPreload(Patient patient, String date) {
        Patient Result;
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
            preparedStatementPerson.setString(2, "patient");
            preparedStatementPerson.setString(3, "go");
            preparedStatementPerson.setString(4, email);
            checker2 = preparedStatementPerson.executeUpdate();

            preparedStatementPerson = connect.prepareStatement("SELECT userID FROM person WHERE name = ? AND occupation = ? AND password = ? AND emailID = ?");
            preparedStatementPerson.setString(1, name);
            preparedStatementPerson.setString(2, "patient");
            preparedStatementPerson.setString(3, "go");
            preparedStatementPerson.setString(4, email);
            resultSet = preparedStatementPerson.executeQuery();
            resultSet.next();
            int patientID = resultSet.getInt("userID");
            //INSERT INTO `person` (`userID`, `name`, `occupation`, `password`, `emailID`) VALUES (1232, 'Ry;an', 'doctor', 'temporary', 'ryan@asu.edu');

            String insertTablePatient = "INSERT INTO patient"
                    + "(patientID, occupation, address, SSN, gender, insurance, age, phone, medicalHistory, healthConditions, date) VALUES"
                    + "(?,?,?,?,?,?,?,?,?,?,?)";

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
            preparedStatementPatient.setString(9, patient.medicalHistory.toString());
            preparedStatementPatient.setString(10, patient.healthConditions.toString());
            preparedStatementPatient.setString(11, date);
            checker = preparedStatementPatient.executeUpdate();

            System.out.println("checker1==============" + checker);
            System.out.println("checker2==============" + checker2);
            System.out.println("Adding info into Patient obj");

            Result = new Patient();
            Result.setOccupation("patient");
            Result.setName(name);
            Result.setUserID(patientID);
            Result.setEmail(email);

            Result.setAddress(address);
            Result.setSSN(SSN);
            Result.setGender(gender);
            Result.setInsurance(insurance);
            Result.setAge(age);
            Result.setPhone(phone);

            if (checker == 0 | checker2 == 0)
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
     *
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
     *
     * @return ArrayList: of all persons with id>1001
     */
    public static ArrayList<Person> deletePatients() {
        System.out.println("===================================");
        System.out.println("WARNING DELETING ALL PATIENTS");
        System.out.println("===================================");
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
            if (checker == 0) {
                System.out.println("Delete failed");
                adminList = null;
            } else
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

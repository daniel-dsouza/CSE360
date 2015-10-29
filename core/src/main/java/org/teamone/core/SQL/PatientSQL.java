package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/9/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 * <p/>
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */

import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * update personal info
     * @param patient with valid PatientID
     * @return
     */
    public static Patient UpdatePersonalInfo(Patient patient) {
        Patient Result = new Patient();
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            PreparedStatement preparedStatementPatient = null;
            PreparedStatement preparedStatementPerson = null;


            // PreparedStatements can use variables and are more efficient
            int patientID = patient.getUserID();
            String name = patient.patientInformation.toStringName();
            String SSN = patient.getSSN();
            String address = patient.patientInformation.toStringAddress();
            String email = patient.patientInformation.getEmail();
            String phone = patient.getPhone();
            String insurance = patient.getInsurance();
            String age = patient.getAge();
            String gender = patient.getGender();
            String occupation = patient.getOccupation();

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
            preparedStatementPerson.setString(1, email);
            preparedStatementPerson.setString(2, name);
            preparedStatementPerson.setInt(3, patientID);


            checker2 = preparedStatementPerson.executeUpdate();

            System.out.println("checker1==============" + checker);
            System.out.println("checker2==============" + checker2);

            Result.setOccupation(occupation);
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
     * get all data from SQL with a patient ID
     * @param patient Patient Object with valid patient ID
     * @return Patient object with all data filled in
     */
    public static Patient getPatientComplete(Patient patient) {
        Patient medicalHistory = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getUserID();


            preparedStatement = connect.prepareStatement("SELECT p2.name, p2.emailID, p.medicalhistory, p.occupation, p.address, p.SSN, p.gender, p.insurance, p.age, p.phone, p.healthConditions  FROM patient p, person p2 where patientID = ? and userID = ?");
            preparedStatement.setInt(1, patient.getUserID());
            preparedStatement.setInt(2, patient.getUserID());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            patient.setOccupation(resultSet.getString("p.occupation"));
            patient.setAddress(resultSet.getString("p.address"));
            patient.setSSN(resultSet.getString("p.SSN"));
            patient.setGender(resultSet.getString("p.gender"));
            patient.setInsurance(resultSet.getString("p.insurance"));
            patient.setAge(resultSet.getString("p.age"));
            patient.setPhone(resultSet.getString("p.phone"));
            patient.setName(resultSet.getString("p2.name"));
            patient.setEmail(resultSet.getString("p2.emailID"));
            String mh = resultSet.getString("p.medicalhistory");
            if(mh ==null)
            {
                System.out.println("No medical history");
            }
            else
                patient.medicalHistory.toMapObj(mh);


            String hc = resultSet.getString("p.healthConditions");
            if(hc ==null)
            {
                System.out.println("No health conditions");
            }else
            patient.healthConditions.toMapObj(hc);


            patient.setUserID(ID);



        } catch (Exception e) {
            System.out.println(e);
            patient = null;
        } finally {
            close();
        }

        return patient;

    }

    /**
     * gets medical history
     * @param patient with valid patient ID
     * @return
     */
    public static Patient getMedicalHistory(Patient patient) {
        Patient medicalHistory = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getUserID();
            String mh = null;

            preparedStatement = connect.prepareStatement("SELECT medicalhistory FROM patient where patientID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            mh = resultSet.getString("medicalhistory");
            patient.medicalHistory.toMapObj(mh);
            patient.setUserID(ID);

        } catch (Exception e) {
            System.out.println(e);
            patient = null;
        } finally {
            close();
        }

        return patient;

    }
    /**
     * sets medical history
     * @param patient with valid patient ID
     * @return
     */
    public static Boolean setMedicalHistory(Patient patient) {
        boolean boolResult;
        String temp = null;

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getUserID();
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

    /**
     * gets health conditions
     * @param patient with valid patient ID
     * @return
     */
    public static Patient getHealthConditions(Patient patient) {
        Patient healthConditions = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getUserID();
            String hc = null;

            preparedStatement = connect.prepareStatement("SELECT healthConditions FROM patient where patientID = ?");
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            hc = resultSet.getString("healthConditions");
            patient.healthConditions.toMapObj(hc);
            patient.setUserID(ID);

        } catch (Exception e) {
            System.out.println(e);
            patient = null;
        } finally {
            close();
        }

        return patient;

    }
    /**
     * set health conditions
     * @param patient with valid patient ID
     * @return
     */
    public static Boolean setHealthConditions(Patient patient) {
        boolean boolResult;
        String temp = null;

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = patient.getUserID();

            String hc = patient.healthConditions.toString();
//checking alert
            List<Integer> myList = new ArrayList<Integer>();
            if (patient.healthConditions.alertReason != null && patient.healthConditions.alertReason != "") {
                preparedStatement = connect.prepareStatement("SELECT patient_id FROM alerts");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                    myList.add(resultSet.getInt("patient_id"));
                    //Retrieve by column name
                System.out.println("=Detected alerts. Patient ids have been added to list");

                java.util.Date dt = patient.healthConditions.alertDateAndTime;
                java.text.SimpleDateFormat sdf =
                        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String alertTime = sdf.format(dt);

                if (myList.contains(patient.getUserID())) {
                    System.out.println("Alert in alerts table is present. Updating now");
                    preparedStatement = connect.prepareStatement("UPDATE alerts set alert_reason = ?, AlertActive=TRUE, alertDateAndTime = ? where patient_id = ?");
                    preparedStatement.setString(1, patient.healthConditions.alertReason);
                    preparedStatement.setString(2, alertTime);
                    preparedStatement.setInt(3, patient.getUserID());
                    preparedStatement.executeUpdate();

                }
                else {
                    System.out.println("Alert in alerts table is NOT present. Inserting now");
                    //INSERT INTO alerts(alert_reason, patient_id,AlertActive) VALUES (":anklePain", 1234,1) ;
                    preparedStatement = connect.prepareStatement("INSERT INTO alerts(alert_reason, patient_id, alertDateAndTime, AlertActive) VALUES (?, ?, ?, TRUE) ;");
                    preparedStatement.setString(1, patient.healthConditions.alertReason);
                    preparedStatement.setInt(2, patient.getUserID());
                    preparedStatement.setString(3, alertTime);

                    preparedStatement.executeUpdate();

                }
            }
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
    /**
     * Returns a list of patients based on Patients.
     * @param queryName: Given a string name
     * @return ArrayList: List of Patients
     */
    public static ArrayList<Patient> getPatientByPatient(String queryName) {

        ArrayList<Patient> patientList = new ArrayList<Patient>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("select userID, name from person where occupation = 'patient' and name like '%" + queryName + "%';");
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setName(rs.getString("name"));
                patient.setUserID(rs.getInt("userID"));
                patientList.add(patient);
            }

        } catch (Exception e) {
            System.out.println(e);
            patientList = null;

        } finally {
            close();
        }
        return patientList;
    }
    /**
     * gets all patients
     * @param
     * @return Arraylist of patients
     */
    public static ArrayList<Patient> getAllPatient() {

        ArrayList<Patient> PatientList = new ArrayList<Patient>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("select userID, name, password, emailID from person where occupation = ?;");
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            preparedStatement.setString(1,"patient");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Patient pers = new Patient();
                pers.setUserID(rs.getInt("userID"));

                //pers= PatientSQL.getPatientComplete(pers);
                pers.setName(rs.getString("name"));
                pers.setEmail(rs.getString("emailID"));
                PatientList.add(pers);
            }

        } catch (Exception e) {
            System.out.println(e);
            PatientList = null;

        } finally {
            close();
        }
        return PatientList;
    }
    /**
     * Returns a list of patients based on doctors.
     * @param doc: Given a staff object
     * @return ArrayList: List of Patients
     */
    public static ArrayList<Patient> getPatientByStaff (Doctor doc) {
        ArrayList<Patient> PatientList = new ArrayList<Patient>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int docID = doc.getUserID();
            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("select patientID from appointment where doctorID = ? and patientID IS NOT NULL;");
            //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
            preparedStatement.setInt(1,docID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Patient pers = new Patient();
                pers.setUserID(rs.getInt("patientID"));

                //pers= PatientSQL.getPatientComplete(pers);
                PatientList.add(pers);
            }

        } catch (Exception e) {
            System.out.println(e);
            PatientList = null;

        } finally {
            close();
        }
        return PatientList;
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
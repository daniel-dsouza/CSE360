package org.teamone.core.SQL;

import org.teamone.core.labs.LabTest;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Lin on 2015/10/19.
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
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            //String mh = patient.toString();

            preparedStatement = connect.prepareStatement("INSERT into prescription set patientID = ?, staffID = ?, type = ?, date = ?");

            preparedStatement.setInt(1, patient.getPatientID());
            preparedStatement.setInt(2, patient.getStaffID());
            preparedStatement.setString(3, patient.getPrescriptionType());
            preparedStatement.setString(4, patient.getStrDateAndTime());
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
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
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


    /**
     *
     * @param LabtestRequest test: LabTestRequest to be added.
     * @return true or false: True if insert into SQL success. false otherwise
     */
    public static Boolean addLabRequest(LabTestRequest test) {
        //only use INSERT sql.
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


           preparedStatement = connect.prepareStatement("INSERT into labtest set patientID = ?, staffID = ?, labReport = ? , date = ?");
            preparedStatement.setInt(1, test.getPatient().getPatientID());
            preparedStatement.setInt(2, test.getStaff().getStaffID());
            preparedStatement.setString(3, test.toString());
            preparedStatement.setString(4, test.getStrDateAndTime());
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
     * @param Labtest patient: LabTest to be added.
     * @return true or false: True if insert into SQL success. false otherwise
     */
    public static Boolean addLabTest(LabTest patient) {
        //only use INSERT sql.
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


            preparedStatement = connect.prepareStatement("INSERT into labtest set patientID = ?, staffID = ?, labReport = ? , date = ?");

            preparedStatement.setInt(1, patient.getPatient().getPatientID());
            preparedStatement.setInt(2, patient.getStaff().getStaffID());
            preparedStatement.setString(3, patient.toString());
            preparedStatement.setString(4, patient.getDate());
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
     * Method returns a list doctors.
     * @param String: Specialty to find in sql
     * @return ArrayList: Arraylist of staff objects
     */
    public static ArrayList<Staff> getListDoctorSpecialty (String specialty) {
        ArrayList<Staff> arrayOfDoctors = new ArrayList<Staff>();
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            //String specialty = staff.getSpecialty();

            preparedStatement = connect.prepareStatement("SELECT person.name as name, person.userID as staffID FROM person WHERE person.userID IN (SELECT staff.staffID FROM staff WHERE staff.specialty = ?) ;");
            preparedStatement.setString(1, specialty);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //Retrieve by column name

                Staff newStaff = new Staff();
                newStaff.setName(resultSet.getString("name"));
                newStaff.setStaffID(resultSet.getInt("staffID"));

                arrayOfDoctors.add(newStaff);
            }
        } catch (Exception e) {
            System.out.println(e);
            arrayOfDoctors = null;
        } finally {
            close();
        }
        return arrayOfDoctors;

    }
    /**
     * get all data from SQL with a staff ID
     * @param staff staff Object with valid staff ID
     * @return staff object with all data filled in
     */
    public static Staff getStaffComplete(Staff staff) {
        //Staff staff = null;
        String temp = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = staff.getStaffID();
            String mh = null;

            preparedStatement = connect.prepareStatement("SELECT p2.name, p2.emailID, p.occupation, p.specialty, p.patientID, p.schedule FROM staff p, person p2 where staffID = ? and userID = ?");
            preparedStatement.setInt(1, staff.getStaffID());
            preparedStatement.setInt(2, staff.getStaffID());
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            staff.setOccupation(resultSet.getString("p.occupation"));
            staff.setSpecialty(resultSet.getString("p.specialty"));
            staff.setPatientID(resultSet.getInt("p.patientID"));
            staff.setSchedule(resultSet.getString("p.schedule"));
            staff.setName(resultSet.getString("p2.name"));
            staff.setEmail(resultSet.getString("p2.emailID"));

        } catch (Exception e) {
            System.out.println(e);
            staff = null;
        } finally {
            close();
        }
        return staff;
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

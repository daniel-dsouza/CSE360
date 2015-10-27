package org.teamone.core.SQL;

import org.teamone.core.appointments.Appointment;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Doctor;
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

            preparedStatement = connect.prepareStatement("INSERT into prescription set patientID = ?, staffID = ?, type = ?, date = ?, quantity = ?");

            preparedStatement.setInt(1, patient.getPatientID());
            preparedStatement.setInt(2, patient.getStaffID());
            preparedStatement.setString(3, patient.getPrescriptionType());
            preparedStatement.setString(4, patient.getStrDateAndTime());
            preparedStatement.setString(5, patient.getQuantity());
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
    public static ArrayList<Prescription> getListPrescription(Patient patient) {

        ArrayList<Prescription> PrescriptionList = new ArrayList<Prescription>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int patientID = patient.getUserID();

            preparedStatement = connect.prepareStatement("SELECT serialNumber, staffID, type, date, quantity  FROM prescription WHERE patientID = ?");
            preparedStatement.setInt(1, patientID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Prescription a = new Prescription();
                a.setPrescriptionID(resultSet.getInt("serialNumber"));
                a.setPatientID(patientID);
                a.setStaffID(resultSet.getInt("staffID"));
                a.setPrescriptionType(resultSet.getString("type"));
                a.setStrDateAndTime(resultSet.getString("date"));
                a.setQuantity(resultSet.getString("quantity"));

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

    public static Prescription getPrescriptionID(Prescription readMe) {

        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int staffID = readMe.getStaffID();
            int patID = readMe.getPatientID();
            String date = readMe.getStrDateAndTime();
            String type = readMe.getPrescriptionType();
            String quantity = readMe.getQuantity();

            preparedStatement = connect.prepareStatement("SELECT serialNumber FROM appointment where staffID = ? and date = ? and type = ? and patientID = ? and quantity = ?");
            preparedStatement.setInt(1, staffID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, type);
            preparedStatement.setInt(4, patID);
            preparedStatement.setString(5, quantity);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            readMe.setPrescriptionID(resultSet.getInt("serialNumber"));

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
        return readMe;
    }

    public static Prescription viewPrescriptonByID(Prescription readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int presID = readMe.getPrescriptionID();

            preparedStatement = connect.prepareStatement("SELECT date, type, quantity, staffID, patientID FROM appointment where serialNumber = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, presID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set


            String date = resultSet.getString("date");
            String type = resultSet.getString("type");
            String quantity = resultSet.getString("quantity");
            int staffID = resultSet.getInt("staffID");
            int patID = resultSet.getInt("patientID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Type:\t" + type);
                System.out.println("Quantity:\t" + quantity);
                System.out.println("StaffID:\t" + staffID);
                System.out.println("PatientID:\t" + patID);*///debugging
            Patient temp = new Patient();
            temp.setUserID(patID);
            temp = PatientSQL.getPatientComplete(temp);
            readMe.setPatient(temp);

            Doctor temp1 = new Doctor();
            temp1.setUserID(staffID);
            readMe.setDoctor(temp1);

            readMe.setStrDateAndTime(date);
            readMe.setPrescriptionType(type);
            readMe.setQuantity(quantity);
            readMe.setPatientID(patID);


        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            readMe = null;
        } finally {
            close();
        }
        return readMe;
    }

    /**
     * Method returns a list doctors.
     * @param string: Specialty to find in sql
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
                newStaff.setUserID(resultSet.getInt("staffID"));

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
     * Method returns a list Appointments for doctor specialty.
     *
     * @param string: Specialty to find in sql.
     * @return ArrayList: Arraylist of appointment objects
     */
    public static ArrayList<Appointment> getListSpecialtyPatient(String specialty) {
        ArrayList<Appointment> arrayOfAppt = new ArrayList<Appointment>();
        try {
            ArrayList<Staff> arrayOfDoctors = getListDoctorSpecialty(specialty);//first search for specialty

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            for (int i = 0; i < arrayOfDoctors.size(); i++) {
                preparedStatement = connect.prepareStatement("SELECT date, patientID FROM appointment WHERE doctorID = ? AND patientID IS NOT NULL;");
                preparedStatement.setInt(1, arrayOfDoctors.get(i).getUserID());
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    //Retrieve by column name

                    Appointment new1 = new Appointment();
                    new1.setDate(resultSet.getString("date"));
                    new1.setPatientID(resultSet.getInt("patientID"));
                    new1.setDoctorID(arrayOfDoctors.get(i).getUserID());
                    arrayOfAppt.add(new1);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            arrayOfAppt = null;
        } finally {
            close();
        }
        return arrayOfAppt;

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
            int ID = staff.getUserID();
            String mh = null;

            preparedStatement = connect.prepareStatement("SELECT p2.name, p2.emailID, p.occupation, p.specialty, p.patientID, p.schedule FROM staff p, person p2 where staffID = ? and userID = ?");
            preparedStatement.setInt(1, staff.getUserID());
            preparedStatement.setInt(2, staff.getUserID());
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

    /**
     * Method returns a list doctors.
     * @param Doctor: doctor with valid id
     * @return ArrayList: Arraylist of patients objects
     */
    public static ArrayList<Patient> getDoctorPatientsList (Doctor doc) {
        ArrayList<Patient> arrayOfPatient = new ArrayList<Patient>();
        try {
            int checker, checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = doc.getUserID();

            preparedStatement = connect.prepareStatement("SELECT patientID from appointment where doctorID = ? and patientID IS NOT NULL;");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                //Retrieve by column name

                Patient new1 = new Patient();
                new1.setUserID(resultSet.getInt("patientID"));
                new1 = PatientSQL.getPatientComplete(new1);

                arrayOfPatient.add(new1);
            }
        } catch (Exception e) {
            System.out.println(e);
            arrayOfPatient = null;
        } finally {
            close();
        }
        return arrayOfPatient;

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

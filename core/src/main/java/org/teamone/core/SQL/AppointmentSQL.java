package org.teamone.core.SQL;

/**
 * Created by Jaime on 10/9/2015.
 * This class will be used to create,view, and edit appointments by both Patients and Staff
 */

import org.teamone.core.appointments.Appointment;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class AppointmentSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * DO NOT USE THIS IN FRONTEND. TESTING BACKEND ONLY
     */
    public static Appointment random()//randomizer so we can loop multiple
    {
        //INSERT INTO `appointment`(`date`, `time`, `doctorID`) VALUES ("2015-10-25","9:00 AM",501),
        Appointment appt = new Appointment();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String date = "2015-";
        //nextInt((max - min) + 1) + min
        int date1 = randomGenerator.nextInt((11 - 10) + 1) + 10;//month
        date += Integer.toString(date1) + "-";
        date1 = randomGenerator.nextInt((28 - 1) + 1) + 1;//day
        if (date1 <= 9)//if generator is less than 9, add 0
        {
            date += "0";
        }
        date += Integer.toString(date1);

        String time = "";
        //nextInt((max - min) + 1)
        int time1 = randomGenerator.nextInt((12 - 0) + 1);//12 hour clock
        String time2 = "";
        if (time1 >= 0 && time1 <= 6 || time1 == 12)//if generator is between midnight and 6:00, then this must be set to PM since no doctors wake up.
        {
            if (time1 == 0)//if this is 0, we cant have 0:00 PM, so we set that 12:00
            {
                time1 = 12;
            }
            time2 = "PM";
        } else {
            if ((randomGenerator.nextInt(10) % 2) == 0)//time between 7 AM to 11:00 AM could be either AM or PM.
                time2 = "AM";
            else
                time2 = "PM";
        }
        time += Integer.toString(time1) + ":00 ";
        time += time2;

        appt.setDate(date);
        appt.setTime(time);
        return appt;
    }

    /**
     * @param readMe Appointment Object with valid doctorID
     * @return list of appointments by doctor
     */
    public static List<Appointment> viewAppointmentByDoctor(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID, serialNumber FROM appointment where doctorID = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment new1 = new Appointment();
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int patID = resultSet.getInt("patientID");

                Patient pat1 = new Patient();

                pat1.setName(LoginSQL.getName(patID));
                pat1.splitName((pat1.getName()));

                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Patient ID:\t" + patID);*///debugging

                new1.setDate(date);
                new1.setTime(time);
                new1.setReason(reason);

                new1.setAppointmentID(resultSet.getInt("serialNumber"));
                new1.setPatient(pat1);
                new1.setPatientID(patID);
                a1.add(new1);

            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;
    }

    /**
     * checks if a date is past or currentFuture.
     *
     * @param date string must be in format yyyy-MM-dd
     * @return true is currentFuture, false is past.
     */

    public static Boolean isDateTodayOrFuture(String date) {

        Date dateToday = new Date();
        Date appointmentDate = new Date();
        SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");

        try {

            Date temp = new Date();
            String todayStr = convertToDate.format(temp);

            dateToday = convertToDate.parse(todayStr);
            appointmentDate = convertToDate.parse(date);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (appointmentDate.compareTo(dateToday) > 0 || appointmentDate.compareTo(dateToday) == 0)
            return true;
        else
            return false;
    }

    /**
     * @param readMe Appointment Object with valid doctorID
     * @return list of future appointments by doctor
     */
    public static List<Appointment> viewFutureAppointmentByDoctor(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            preparedStatement = connect.prepareStatement("SELECT date, time, reason, patientID, serialNumber FROM appointment where doctorID = ? AND patientID IS NOT NULL and date ");
            preparedStatement.setInt(1, docID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment new1 = new Appointment();
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int patID = resultSet.getInt("patientID");

                if (isDateTodayOrFuture(date)) {
                    Patient pat1 = new Patient();
                    pat1.setName(LoginSQL.getName(patID));
                    pat1.splitName((pat1.getName()));

                    new1.setDate(date);
                    new1.setTime(time);
                    new1.setReason(reason);

                    new1.setAppointmentID(resultSet.getInt("serialNumber"));
                    new1.setPatient(pat1);
                    new1.setPatientID(patID);
                    a1.add(new1);

                }
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;
    }


    /**
     * Given an appoint with doctorID, Time, PatientID, and Date, return ID
     *
     * @param readMe Appointment Object with valid  doctorID, Time, PatientID, and Date,
     * @return appoint with appointmentID
     */
    public static Appointment getAppointmentID(Appointment readMe) {

        try {

            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int docID = readMe.getDoctorID();
            int patID = readMe.getPatientID();
            String time = readMe.getTime();
            String date = readMe.getDate();
            preparedStatement = connect.prepareStatement("SELECT serialNumber FROM appointment where doctorID = ? and date = ? and time = ? and patientID = ?");
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            preparedStatement.setInt(4, patID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            readMe.setAppointmentID(resultSet.getInt("serialNumber"));

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
     * @param readMe Appointment Object with valid patientID
     * @return list of appointments by patient
     */

    public static List<Appointment> viewFutureAppointmentByPatient(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID, serialNumber FROM appointment where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment new1 = new Appointment();

                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int docID = resultSet.getInt("doctorID");
                Staff temp = new Staff();
                temp.setUserID(docID);
                Staff doc1 = DoctorSQL.getStaffComplete(temp);

                if (isDateTodayOrFuture(date)) {

                    new1.setDate(date);
                    new1.setTime(time);
                    new1.setReason(reason);
                    new1.setPatientID(docID);
                    new1.setAppointmentID(resultSet.getInt("serialNumber"));
                    new1.setDoctor(doc1);
                    a1.add(new1);
                }
            }

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;

    }

    /**
     * @param readMe Appointment Object with valid patientID
     * @return list of appointments by patient
     */

    public static List<Appointment> viewAppointmentByPatient(Appointment readMe) {
        List<Appointment> a1 = new ArrayList<Appointment>();

        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int patID = readMe.getPatientID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID, serialNumber FROM appointment where patientID = ?");
            preparedStatement.setInt(1, patID);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Appointment new1 = new Appointment();

                String date = resultSet.getString("date");
                String time = resultSet.getString("time");
                String reason = resultSet.getString("reason");
                int docID = resultSet.getInt("doctorID");
                Staff temp = new Staff();
                temp.setUserID(docID);
                Staff doc1 = DoctorSQL.getStaffComplete(temp);



                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging

                new1.setDate(date);
                new1.setTime(time);
                new1.setReason(reason);
                new1.setPatientID(docID);
                new1.setAppointmentID(resultSet.getInt("serialNumber"));
                new1.setDoctor(doc1);
                a1.add(new1);

            }

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            a1 = null;
        } finally {
            close();
        }
        return a1;

    }


    /**
     * @param readMe Appointment Object with valid appointmentID
     * @return appointment by appointment ID
     */
    public static Appointment viewAppointmentByApptID(Appointment readMe) {


        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int appID = readMe.getAppointmentID();

            preparedStatement = connect.prepareStatement("SELECT date, time, reason, doctorID, patientID FROM appointment where serialNumber = ? AND patientID IS NOT NULL");
            preparedStatement.setInt(1, appID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set


            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String reason = resultSet.getString("reason");
            int docID = resultSet.getInt("doctorID");
            int patID = resultSet.getInt("patientID");
                /*System.out.println("Date:\t" + date);
                System.out.println("Time:\t" + time);
                System.out.println("Reason:\t" + reason);
                System.out.println("Doctor ID:\t" + docID);*///debugging
            Patient temp = new Patient();
            temp.setUserID(patID);
            //temp = PatientSQL.getPatientComplete(temp);
            readMe.setPatient(temp);

            Doctor temp1 = new Doctor();
            temp1.setUserID(docID);
            readMe.setDoctor(temp1);

            readMe.setDate(date);
            readMe.setTime(time);
            readMe.setReason(reason);
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
     * Create appointment used by doctors
     * This is will use doctorID, date and time to edit the SQL.
     *
     * @param readMe Appointment Object with valid doctorID, date and time
     * @return Appointment
     */
    public static Boolean createAppointment(Appointment readMe) {
        Boolean Result;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();


            String selectApp = "SELECT serialNumber from appointment "
                    + "where doctorID = ?  AND date = ? AND time = ?;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(selectApp);
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first())//if Resultset does exist,
            {
                Result = false;//so there exists a time. return false. can not insert the same appointment
            } else {
                String insertApp = "INSERT INTO appointment "
                        + "(doctorID, date, time) VALUES"
                        + "(?,?,?);";
                preparedStatement = connect.prepareStatement(insertApp);
                preparedStatement.setInt(1, docID);
                preparedStatement.setString(2, date);
                preparedStatement.setString(3, time);
                preparedStatement.executeUpdate();

                Result = true;
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;

        }
        return Result;
    }

    /**
     * Preloads the database with appointments
     * NO FRONTEND SHOULD CALL THIS
     *
     * @param readMe Appointment Object
     * @return boolean
     */
    public static boolean preloadAppointment(Appointment readMe) {
        boolean result = false;
        try {
            int checker = 0;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String insertApp = "INSERT INTO appointment "
                    + "(doctorID, date, time) VALUES"
                    + "(?,?,?);";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(insertApp);
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            checker = preparedStatement.executeUpdate();

            if (checker == 0)
                result = false;
            else
                result = true;

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            result = false;
        } finally {
            close();
        }
        return result;
    }

    /**
     * Delete an appointment by ID
     *
     * @param oldID: appointmentID to be Deleted
     * @return Boolean
     */
    public static Boolean delAppointmentAppt(int oldID) {
        Boolean Result;
        try {
            int checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);


            String delApp = "DELETE from appointment WHERE serialNumber = ?;";
            preparedStatement = connect.prepareStatement(delApp);
            preparedStatement.setInt(1, oldID);
            checker2 = preparedStatement.executeUpdate();

            if (checker2 == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Delete all appointments will patient - null
     *
     * @return Boolean
     */
    public static Boolean delAllAppointmentByPatient() {
        Boolean Result;
        try {
            int checker2;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);


            String delApp = "DELETE from appointment WHERE patientID IS NULL;";
            preparedStatement = connect.prepareStatement(delApp);
            checker2 = preparedStatement.executeUpdate();

            if (checker2 == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * given an Appointment with valid info, and the old appointmentID, this will update it.
     * <p/>
     * case 1: if the patient only updates the reason, then we can check if the readMe is the same as oldID
     * case 2: if the patient changes date and time, then we need to get the oldID and update that will new values
     *
     * @param readMe Appointment Object with valid appointmentID, docID, date,time, patID
     * @return Boolean
     */
    public static Boolean updateAppointmentAppt(Appointment readMe, int oldID) {
        Boolean Result = false;
        int checker = 0, checker2 = 0;
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            int patID = readMe.getPatientID();
            String reason = readMe.getReason();

            String selectApp = "SELECT serialNumber from appointment "
                    + "where doctorID = ?  AND date = ? AND time = ?;";
            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement(selectApp);
            preparedStatement.setInt(1, docID);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {

                //update the reason since the docID and date and time is present. If appointment exists, this should ALWAYS be true

                String updateApp = "UPDATE appointment SET"
                        + " reason = ? WHERE serialNumber = ? ;";

                preparedStatement = connect.prepareStatement(updateApp);
                preparedStatement.setString(1, reason);
                preparedStatement.setInt(2, oldID);
                checker = preparedStatement.executeUpdate();
                Result = true;

            } else //if docID, date OR time is changed, we need the oldID and update that
            {

                String updateApp = "UPDATE appointment SET"
                        + " reason = ?, patientID = ?, doctorID = ?, date = ?, time = ? WHERE serialNumber = ? ;";

                preparedStatement = connect.prepareStatement(updateApp);
                preparedStatement.setString(1, reason);
                preparedStatement.setInt(2, patID);
                preparedStatement.setInt(3, docID);
                preparedStatement.setString(4, date);
                preparedStatement.setString(5, time);
                preparedStatement.setInt(6, oldID);
                checker = preparedStatement.executeUpdate();
                Result = true;

            }

        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Schedule an existing appointment by Appointment ID. This is because SQL is checked for a duplicate using createAppt method
     *
     * @param readMe Appointment Object with valid doctorID, date, time
     * @return Boolean
     */
    public static Boolean schedAppointment(Appointment readMe) {
        Boolean Result;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int appID = readMe.getAppointmentID();
            int patID = readMe.getPatientID();
            int docID = readMe.getDoctorID();
            String date = readMe.getDate();
            String time = readMe.getTime();
            String reason = readMe.getReason();

            String updateApp = "UPDATE appointment SET"
                    + " reason = ?, patientID = ? WHERE doctorID = ? AND date = ? AND time = ?;";

            preparedStatement = connect.prepareStatement(updateApp);
            preparedStatement.setString(1, reason);
            preparedStatement.setInt(2, patID);
            preparedStatement.setInt(3, docID);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, time);
            checker = preparedStatement.executeUpdate();


            if (checker == 0)
                Result = false;
            else
                Result = true;
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            Result = false;
        } finally {
            close();
        }
        return Result;

    }

    /**
     * Returns a list of patients' appointment
     *
     * @param patientName: String Name must be exact
     * @return ArrayList: Arraylist of Patient objects
     */
    public static ArrayList<Appointment> getPatientsAppointment(String patientName) {

        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            preparedStatement = connect.prepareStatement("select userID from person where name = ?");
            preparedStatement.setString(1, patientName);
            ResultSet rs2 = preparedStatement.executeQuery();
            if (rs2.next()) {
                int patientID = rs2.getInt("userID");


                preparedStatement = connect.prepareStatement("select serialNumber, date, time, reason, doctorID, patientID from appointment where patientID = " + patientID);
                //preparedStatementPatient = connect.prepareStatement("select userID from person where lName like '%" + queryName + "%' or lName like '%" + queryName + "%';");
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    Appointment appt = new Appointment();
                    appt.setDate(rs.getString("date"));
                    appt.setTime(rs.getString("time"));
                    appt.setReason(rs.getString("reason"));
                    appt.setDoctorID(rs.getInt("doctorID"));
                    appt.setPatientID(rs.getInt("patientID"));
                    appt.setAppointmentID(rs.getInt("serialNumber"));
                    apptList.add(appt);
                }
            } else {
                System.out.println("\nName not found.");
                apptList = null;
            }
        } catch (Exception e) {
            System.out.println(e);
            apptList = null;
        } finally {
            close();
        }
        return apptList;
    }

    /**
     * Returns a list of Appointments already created
     *
     * @param doc: Doctor with staff ID filled in
     * @return ArrayList: Arraylist of Appointment objects
     */
    public static ArrayList<Appointment> getOccupiedTimes(Doctor doc) {
        ArrayList<Appointment> apptList = new ArrayList<Appointment>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            int docID = doc.getUserID();
            preparedStatement = connect.prepareStatement("select date, time, serialNumber from appointment where doctorID  = ?");
            preparedStatement.setInt(1, docID);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String date = rs.getString("date");
                if (isDateTodayOrFuture(date)) {
                    Appointment appt = new Appointment();
                    appt.setDate(date);
                    appt.setTime(rs.getString("time"));
                    appt.setDoctorID(docID);
                    apptList.add(appt);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            apptList = null;
        } finally {
            close();
        }
        return apptList;

    }




    /**
     * Method used for closing the sql library functions
     */
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

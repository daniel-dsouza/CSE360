package org.teamone.core.SQL;

import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Ryan on 10/22/2015.
 * ONLY LAB REQUESTS OBJECTS OR ARRAYLISTS
 */
public class LabRequestSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     *
     * @param test: LabTestRequest to be added.
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


            preparedStatement = connect.prepareStatement("INSERT into labtest set patientID = ?, staffID = ?, labReport = ? , date = ?, labType = ?");
            preparedStatement.setInt(1, test.getPatient().getUserID());
            preparedStatement.setInt(2, test.getPerson().getUserID());
            preparedStatement.setString(3, test.toString());
            preparedStatement.setString(4, test.getStrDateAndTime());
            preparedStatement.setString(5, "labRequest");
            checker = preparedStatement.executeUpdate();

            boolResult = checker != 0;

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
     * @param LabTestRequest: Valid LabTestRequest with a requestionID
     * @return LabTestRequest: returns a LabTestRequest object
     */
    public static LabTestRequest viewLabRequest(LabTestRequest readMe) {
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int reqID = readMe.getRequestionID();

            preparedStatement = connect.prepareStatement("SELECT labReport, date, patientID, staffID FROM labtest where serialNumber = ? and labType = ?");
            preparedStatement.setInt(1, reqID);
            preparedStatement.setString(2, "labRequest");
            resultSet = preparedStatement.executeQuery();
            resultSet.next();// ResultSet is initially before the first data set

            String labReport = resultSet.getString("labReport");
            String date = resultSet.getString("date");
            int patID = resultSet.getInt("patientID");
            int stafID = resultSet.getInt("staffID");

            if (patID != 0) //if it does not equal zero, great, we can set it
            {
                if(readMe.getPatient() == null)//uh oh, patient does not yet exists so, create one
                {
                    Patient new1= new Patient();
                    readMe.setPatient(new1);
                }
                readMe.getPatient().setUserID(patID);
            }

            if (!date.equals("null") &&  !labReport.equals(null)) {
                readMe.setStrDateAndTime(date);
                readMe.toMapObj(labReport);
                if(readMe.getPerson() == null)//uh oh, person does not yet exists so, create one
                {
                    Person new1 = new Person();
                    readMe.setPerson(new1);
                }
                readMe.getPerson().setUserID(stafID);
            }

            else
            {
                System.out.println("===========EMPTY RESULT========RETURN NULL");
                readMe = null;
            }
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
     * Gets everything from table labtests
     * @return ArrayList: list of LabTestRequest
     */
    public static ArrayList<LabTestRequest> getAllLabRequests() {
        ArrayList<LabTestRequest> LabTestRequestList = new ArrayList<LabTestRequest>();

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());

            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient


            preparedStatement = connect.prepareStatement("SELECT serialNumber, labReport, date, patientID, staffID FROM labtest where labType = ?");
            preparedStatement.setString(1, "labRequest");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LabTestRequest new1 = new LabTestRequest();
                new1.setRequestionID(resultSet.getInt("serialNumber"));
                new1.toMapObj(resultSet.getString("labReport"));
                Patient pat = new Patient();
                pat.setUserID(resultSet.getInt("patientID"));
                new1.setPatient(pat); //added to get patient ID.
                Person per = new Person();
                per.setUserID(resultSet.getInt("staffID"));
                new1.setPerson(per);
                LabTestRequestList.add(new1);
            }
        } catch (Exception e) {
            System.out.println("===========EMPTY RESULT========RETURN NULL");
            System.out.println(e);
            LabTestRequestList = null;
        } finally {
            close();
        }
        return LabTestRequestList;

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

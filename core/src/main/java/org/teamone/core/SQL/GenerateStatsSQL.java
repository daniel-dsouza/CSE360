package org.teamone.core.SQL;

import org.teamone.core.users.Alert;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Staff;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Stephanie on 10/24/2015.
 */
public class GenerateStatsSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public static int getNumOfAlerts(Alert alert) {
        int numOfAlerts = 0;
        String date;
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("SELECT alert_id, alertDateAndTime  FROM alerts WHERE AlertActive = 1;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                date = getDate(resultSet.getString("alertdateAndTime"));
                SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar dateAfter1Month = Calendar.getInstance();

                Date finalDate = convertToDate.parse(date);

                dateAfter1Month.add(Calendar.MONTH, 1);

                Calendar dateBefore1Month = Calendar.getInstance();
                dateBefore1Month.add(Calendar.MONTH, -1);

                if(finalDate.before(dateAfter1Month.getTime()) && finalDate.after(dateBefore1Month.getTime()))
                {

                    numOfAlerts++;

                }



            }

        } catch (Exception e) {
            System.out.println(e);
            numOfAlerts = 0;
        } finally {
            close();
        }
        return numOfAlerts;
    }


    public static int getNumOfNewPatients(Patient patient)
    {

        int patientCount = 0;
        String date;
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("SELECT date FROM patient WHERE occupation = 'patient';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                date = resultSet.getString("date");
                SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar dateAfter1Month = Calendar.getInstance();

                Date finalDate = convertToDate.parse(date);

                dateAfter1Month.add(Calendar.MONTH, 1);

                Calendar dateBefore1Month = Calendar.getInstance();
                dateBefore1Month.add(Calendar.MONTH, -1);

                if(finalDate.before(dateAfter1Month.getTime()) && finalDate.after(dateBefore1Month.getTime()))
                {

                    patientCount++;

                }



            }

        } catch (Exception e) {
            System.out.println(e);
            patientCount = 0;
        } finally {
            close();
        }
        return patientCount;


    }

    public static double getMalePopulation(Patient patient)
    {
        double male = 0;
        double totalNumOfPatients = 0;
        double malePercentage = 0;
        String gender = "";
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("SELECT gender FROM patient WHERE occupation = 'patient';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                gender = resultSet.getString("gender");
                if(gender.equals("Male") || gender.equals("male"))

                {
                    male++;

                }

                totalNumOfPatients++;
            }

            malePercentage = (male/totalNumOfPatients)*100;


        } catch (Exception e) {
            System.out.println(e);
            male = 0;
        } finally {
            close();
        }

        return malePercentage;
    }

    public static double getFemalePopulation(Patient patient)
    {
        double female = 0;
        double totalNumOfPatients = 0;
        double femalePercentage = 0;
        String gender = "";
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            preparedStatement = connect.prepareStatement("SELECT gender FROM patient WHERE occupation = 'patient';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                gender = resultSet.getString("gender");
                if(gender.equals("Female") || gender.equals("female"))

                {

                    female++;

                }

                totalNumOfPatients++;
            }

            femalePercentage = (female/totalNumOfPatients)*100;


        } catch (Exception e) {
            System.out.println(e);
            female = 0;
        } finally {
            close();
        }

        return femalePercentage;
    }


    public static void getAgePopulation(Patient patient)
    {
        double ag1 = 0;
        double ag2 = 0;
        double ag3 = 0;
        double ag4 = 0;
        double ag5 = 0;
        double ag6 = 0;
        double ag7 = 0;
        double ag8 = 0;

        int totalNumOfPatients = 0;
        int age = 0;

        double ag1Percentage = 0;
        double ag2Percentage = 0;
        double ag3Percentage = 0;
        double ag4Percentage = 0;
        double ag5Percentage = 0;
        double ag6Percentage = 0;
        double ag7Percentage = 0;
        double ag8Percentage = 0;

        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            String test = "patient";

            preparedStatement = connect.prepareStatement("SELECT age FROM patient WHERE occupation = 'patient';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                age = resultSet.getInt("age");
                if(age >=0 && age <=12 )
                {

                    ag1++;

                }

                else if(age >=13 && age <=18 )
                {
                    ag2++;

                }

                else if(age >=19 && age <=26 )
                {
                    ag3++;

                }

                else if(age >=27 && age <=40 )
                {
                    ag4++;

                }

                else if(age >=41 && age <=50 )
                {
                    ag5++;

                }

                else if(age >=51 && age <=60 )
                {
                    ag6++;

                }

                else if(age >=61 && age <=74 )
                {
                    ag7++;

                }

                else if(age >=75)
                {
                    ag8++;

                }

                totalNumOfPatients++;
            }

            ag1Percentage = (ag1/totalNumOfPatients)*100;
            ag2Percentage = (ag2/totalNumOfPatients)*100;
            ag3Percentage = (ag3/totalNumOfPatients)*100;
            ag4Percentage = (ag4/totalNumOfPatients)*100;
            ag5Percentage = (ag5/totalNumOfPatients)*100;
            ag6Percentage = (ag6/totalNumOfPatients)*100;
            ag7Percentage = (ag7/totalNumOfPatients)*100;
            ag8Percentage = (ag8/totalNumOfPatients)*100;

            System.out.println("Ages 0-12: " + String.format("%.2f", ag1Percentage) + "%");
            System.out.println("Ages 13-18: " + String.format("%.2f", ag2Percentage) + "%");
            System.out.println("Ages 19-26: " + String.format("%.2f", ag3Percentage) + "%");
            System.out.println("Ages 27-40: " + String.format("%.2f", ag4Percentage) + "%");
            System.out.println("Ages 41-50: " + String.format("%.2f", ag5Percentage) + "%");
            System.out.println("Ages 51-60: " + String.format("%.2f", ag6Percentage) + "%");
            System.out.println("Ages 61-74: " + String.format("%.2f", ag7Percentage) + "%");
            System.out.println("Ages 75 & Up: " + String.format("%.2f", ag8Percentage) + "%");



        } catch (Exception e) {
            System.out.println(e);
            ag1Percentage = 0;
            ag2Percentage = 0;
            ag3Percentage = 0;
            ag4Percentage = 0;
            ag5Percentage = 0;
            ag6Percentage = 0;
            ag7Percentage = 0;
            ag8Percentage = 0;

        } finally {
            close();
        }

    }

    public static void getNumOfPatientType(Staff staff)
    {
        //INCOMPLETE METHOD STILL NEED TO FINISH ONCE MISSING METHOD HAS BEEN IMPLEMENTED

        double pediatrician = 0;
        double generalCare = 0;
        double emergency = 0;
        double xRay = 0;

        double totalNumOfPatients = 0;
        String specialty = "";

        double pedsPercentage = 0;
        double genPercentage = 0;
        double emergPercentage = 0;
        double xRayPercentage = 0;


        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            String test = "patient";

            preparedStatement = connect.prepareStatement("SELECT specialty FROM staff WHERE occupation != 'hsp' and occupation!= 'labstaff';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


               specialty = resultSet.getString("specialty");

                if(specialty.equals("Pediatrician"))
                {

                    //resultSet.get

                        pediatrician++;

                }

                else if(specialty.equals("GeneralCare"))
                {

                    generalCare++;

                }
                else if(specialty.equals("Emergency"))
                {

                    emergency++;

                }
                else if(specialty.equals("X-ray"))
                {

                    xRay++;

                }



            }

                totalNumOfPatients = pediatrician+generalCare+emergency+xRay;

            pedsPercentage = (pediatrician/totalNumOfPatients)*100;
            genPercentage = (generalCare/totalNumOfPatients)*100;
            emergPercentage = (emergPercentage/totalNumOfPatients)*100;
            xRayPercentage = (xRay/totalNumOfPatients)*100;

            System.out.println("Pediatrician: " + pedsPercentage + "%");
            System.out.println("General Care: " + genPercentage + "%");
            System.out.println("Emergency: " + emergPercentage + "%");
            System.out.println("X-ray: " + xRayPercentage + "%");



        } catch (Exception e) {
            System.out.println(e);
            pedsPercentage = 0;
            genPercentage = 0;
            emergPercentage = 0;
            xRayPercentage = 0;

        } finally {
            close();
        }

    }


    public static String getDate(String dateAndTime)
    {
        String date = "";
        int position = 0;
        position = dateAndTime.indexOf(" ");

        date = dateAndTime.substring(0, position);

        return date;

    }




    /**
     * get list of alerts
     * @return arraylist
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
            System.out.println(e);
        }
    }
}

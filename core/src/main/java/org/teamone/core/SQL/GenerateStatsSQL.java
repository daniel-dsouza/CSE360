package org.teamone.core.SQL;

import org.teamone.core.appointments.Appointment;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Stephanie on 10/24/2015.
 */
public class GenerateStatsSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public static ArrayList<Integer> getNumOfAlerts() {
        ArrayList<Integer> alertsList = new ArrayList<Integer>();
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int june = 0;
        int july = 0;
        int aug = 0;
        int sept = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;

        String date;
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect.prepareStatement("SELECT alert_id, alertDateAndTime  FROM alerts;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                date = getDate(resultSet.getString("alertdateAndTime"));
                if (is1YearRange(date)) {
                    SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar temp = Calendar.getInstance();
                    Date currDate = convertToDate.parse(date);
                    temp.setTime(currDate);
                    int month = temp.get(Calendar.MONTH);

                    switch (month) {
                        case 0:
                            jan++;
                            break;
                        case 1:
                            feb++;
                            break;
                        case 2:
                            mar++;
                            break;
                        case 3:
                            apr++;
                            break;
                        case 4:
                            may++;
                            break;
                        case 5:
                            june++;
                            break;
                        case 6:
                            july++;
                            break;
                        case 7:
                            aug++;
                            break;
                        case 8:
                            sept++;
                            break;
                        case 9:
                            oct++;
                            break;
                        case 10:
                            nov++;
                            break;
                        case 11:
                            dec++;
                            break;
                        default:
                            System.out.println("Month is not found");
                            break;

                    }
                }

                /*SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                Calendar dateAfter1Month = Calendar.getInstance();

                Date finalDate = convertToDate.parse(date);

                dateAfter1Month.add(Calendar.MONTH, 1);

                Calendar dateBefore1Month = Calendar.getInstance();
                dateBefore1Month.add(Calendar.MONTH, -1);

                if(finalDate.before(dateAfter1Month.getTime()) && finalDate.after(dateBefore1Month.getTime()))
                {

                    numOfAlerts++;

                }*/
                Integer[] intArray = new Integer[]{jan, feb, mar, apr, may, june, july, aug, sept, oct, nov, dec};
                alertsList = new ArrayList<Integer>(Arrays.asList(intArray));
            }

        } catch (Exception e) {
            System.out.println(e);
            alertsList = null;
        } finally {
            close();
        }
        return alertsList;
    }

    public static boolean is1YearRange(String date1) {

        boolean oneYear = false;

        try {

            SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
            Calendar dateAfter1Month = Calendar.getInstance();

            Date finalDate = convertToDate.parse(date1);
            dateAfter1Month.add(Calendar.MONTH, 12);
            Calendar dateBefore1Month = Calendar.getInstance();

            dateBefore1Month.add(Calendar.MONTH, -12);
            if (finalDate.before(dateAfter1Month.getTime()) && finalDate.after(dateBefore1Month.getTime())) {

                oneYear = true;

            }


        } catch (Exception e) {
            System.out.println(e);
            oneYear = false;
        }
        return oneYear;
    }

    public static ArrayList<Integer> getNumOfNewPatients() {
        ArrayList<Integer> patientList = new ArrayList<Integer>();
        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int june = 0;
        int july = 0;
        int aug = 0;
        int sept = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;

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

                date = getDate(resultSet.getString("date"));

                if (is1YearRange(date)) {
                    SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar temp = Calendar.getInstance();

                    Date currMonth = convertToDate.parse(date);
                    temp.setTime(currMonth);
                    int month = temp.get(Calendar.MONTH);

                    switch (month) {
                        case 0:
                            jan++;
                            break;
                        case 1:
                            feb++;
                            break;
                        case 2:
                            mar++;
                            break;
                        case 3:
                            apr++;
                            break;
                        case 4:
                            may++;
                            break;
                        case 5:
                            june++;
                            break;
                        case 6:
                            july++;
                            break;
                        case 7:
                            aug++;
                            break;
                        case 8:
                            sept++;
                            break;
                        case 9:
                            oct++;
                            break;
                        case 10:
                            nov++;
                            break;
                        case 11:
                            dec++;
                            break;
                        default:
                            System.out.println("Month is not found");
                            break;

                    }
                }
                /*dateAfter1Month.add(Calendar.MONTH, 1);

                Calendar dateBefore1Month = Calendar.getInstance();
                dateBefore1Month.add(Calendar.MONTH, -1);

                if(finalDate.before(dateAfter1Month.getTime()) && finalDate.after(dateBefore1Month.getTime()))
                {

                    patientCount++;

                }*/

            }


            Integer[] intArray = new Integer[]{jan, feb, mar, apr, may, june, july, aug, sept, oct, nov, dec};
            patientList = new ArrayList<Integer>(Arrays.asList(intArray));


        } catch (Exception e) {
            System.out.println(e);
            patientList = null;
        } finally {
            close();
        }
        return patientList;


    }

    public static double getMalePopulation() {
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
                if (gender.equals("Male") || gender.equals("male"))

                {
                    male++;

                }

                totalNumOfPatients++;
            }

            malePercentage = (male / totalNumOfPatients) * 100;

            malePercentage = RoundTo2Decimals(malePercentage);

        } catch (Exception e) {
            System.out.println(e);
            male = 0;
        } finally {
            close();
        }

        return malePercentage;
    }

    public static double getFemalePopulation() {
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
                if (gender.equals("Female") || gender.equals("female"))

                {

                    female++;

                }

                totalNumOfPatients++;
            }

            femalePercentage = (female / totalNumOfPatients) * 100;
            femalePercentage = RoundTo2Decimals(femalePercentage);

        } catch (Exception e) {
            System.out.println(e);
            female = 0;
        } finally {
            close();
        }

        return femalePercentage;
    }


    public static double[] getAgePopulation() {
        double[] groups = new double[8];

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
            preparedStatement = connect.prepareStatement("SELECT age FROM patient WHERE occupation = 'patient';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                age = resultSet.getInt("age");
                if (age >= 0 && age <= 12) {

                    ag1++;

                } else if (age >= 13 && age <= 18) {
                    ag2++;

                } else if (age >= 19 && age <= 26) {
                    ag3++;

                } else if (age >= 27 && age <= 40) {
                    ag4++;

                } else if (age >= 41 && age <= 50) {
                    ag5++;

                } else if (age >= 51 && age <= 60) {
                    ag6++;

                } else if (age >= 61 && age <= 74) {
                    ag7++;

                } else if (age >= 75) {
                    ag8++;

                }

                totalNumOfPatients++;
            }

            ag1Percentage = (ag1 / totalNumOfPatients) * 100;
            ag2Percentage = (ag2 / totalNumOfPatients) * 100;
            ag3Percentage = (ag3 / totalNumOfPatients) * 100;
            ag4Percentage = (ag4 / totalNumOfPatients) * 100;
            ag5Percentage = (ag5 / totalNumOfPatients) * 100;
            ag6Percentage = (ag6 / totalNumOfPatients) * 100;
            ag7Percentage = (ag7 / totalNumOfPatients) * 100;
            ag8Percentage = (ag8 / totalNumOfPatients) * 100;


            ag1Percentage = RoundTo2Decimals(ag1Percentage);
            ag2Percentage = RoundTo2Decimals(ag2Percentage);
            ag3Percentage = RoundTo2Decimals(ag3Percentage);
            ag4Percentage = RoundTo2Decimals(ag4Percentage);
            ag5Percentage = RoundTo2Decimals(ag5Percentage);
            ag6Percentage = RoundTo2Decimals(ag6Percentage);
            ag7Percentage = RoundTo2Decimals(ag7Percentage);
            ag8Percentage = RoundTo2Decimals(ag8Percentage);


            groups[0] = ag1Percentage;
            groups[1] = ag2Percentage;
            groups[2] = ag3Percentage;
            groups[3] = ag4Percentage;
            groups[4] = ag5Percentage;
            groups[5] = ag6Percentage;
            groups[6] = ag7Percentage;
            groups[7] = ag8Percentage;

            /*System.out.println("Ages 0-12: " + ag1Percentage + "%");
            System.out.println("Ages 13-18: " + ag2Percentage + "%");
            System.out.println("Ages 19-26: " + ag3Percentage + "%");
            System.out.println("Ages 27-40: " + ag4Percentage + "%");
            System.out.println("Ages 41-50: " + ag5Percentage + "%");
            System.out.println("Ages 51-60: " + ag6Percentage + "%");
            System.out.println("Ages 61-74: " + ag7Percentage + "%");
            System.out.println("Ages 75 & Up: " + ag8Percentage + "%"); */


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

        return groups;

    }

    public static double RoundTo2Decimals(double val) {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }

    public static ArrayList<Integer> countingPatientTypes(ArrayList<Appointment> currDoctorSpecialty)
    {
        ArrayList<Integer> pediatricianTypes = new ArrayList<Integer>();

        int jan = 0;
        int feb = 0;
        int mar = 0;
        int apr = 0;
        int may = 0;
        int june = 0;
        int july = 0;
        int aug = 0;
        int sept = 0;
        int oct = 0;
        int nov = 0;
        int dec = 0;

        try {

            for(int i = 0; i < currDoctorSpecialty.size(); i ++) {
                String date = currDoctorSpecialty.get(i).getDate();
                if (is1YearRange(date)) {
                    SimpleDateFormat convertToDate = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar temp = Calendar.getInstance();
                    Date currMonth = convertToDate.parse(date);
                    temp.setTime(currMonth);
                    int month = temp.get(Calendar.MONTH);

                    switch (month) {
                        case 1:
                            jan++;
                            break;
                        case 2:
                            feb++;
                            break;
                        case 3:
                            mar++;
                            break;
                        case 4:
                            apr++;
                            break;
                        case 5:
                            may++;
                            break;
                        case 6:
                            june++;
                            break;
                        case 7:
                            july++;
                            break;
                        case 8:
                            aug++;
                            break;
                        case 9:
                            sept++;
                            break;
                        case 10:
                            oct++;
                            break;
                        case 11:
                            nov++;
                            break;
                        case 12:
                            dec++;
                            break;
                        default:
                            System.out.println("Month is not found");
                            break;

                    }
                }
            }
            pediatricianTypes.add(jan);
            pediatricianTypes.add(feb);
            pediatricianTypes.add(mar);
            pediatricianTypes.add(apr);
            pediatricianTypes.add(may);
            pediatricianTypes.add(june);
            pediatricianTypes.add(july);
            pediatricianTypes.add(aug);
            pediatricianTypes.add(sept);
            pediatricianTypes.add(oct);
            pediatricianTypes.add(nov);
            pediatricianTypes.add(dec);

        } catch (Exception e) {
            System.out.println(e);
            pediatricianTypes = null;

        } finally {
            close();
        }

        return pediatricianTypes;

    }

    public static ArrayList<ArrayList<Integer>> getNumOfPatientType()
    {
        ArrayList<ArrayList<Integer>> patientType = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> pediatricianType = new ArrayList<Integer>();
        ArrayList<Integer> generalCareType = new ArrayList<Integer>();
        ArrayList<Integer> emergencyType = new ArrayList<Integer>();
        ArrayList<Integer> neurologistType = new ArrayList<Integer>();
        ArrayList<Integer> xrayType = new ArrayList<Integer>();

        String listSpecialty = "";
        try {

            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql for: " + Thread.currentThread().getStackTrace()[1].getMethodName());
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient

            List<String> myList = new ArrayList<String>();
            preparedStatement = connect.prepareStatement("SELECT specialty FROM staff WHERE occupation = 'Doctor';");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                listSpecialty = resultSet.getString("specialty");
                if (myList.contains(listSpecialty)) {
                    //do nothing

                } else {
                    myList.add(listSpecialty);
                    //System.out.println(listSpecialty);
                }
            }

            for (int j = 0; j < myList.size(); j++) {
                String specialty = myList.get(j);
                ArrayList<Appointment> doctorSpecialty = DoctorSQL.getListSpecialtyPatient(specialty);
                int arraySize = doctorSpecialty.size();
                if (specialty.equals("Pediatrician")) {

                    pediatricianType = countingPatientTypes(doctorSpecialty);

                }

                else if(specialty.equals("GeneralCare"))
                {
                    generalCareType = countingPatientTypes(doctorSpecialty);

                }

                else if(specialty.equals("Neurologist"))
                {
                    neurologistType = countingPatientTypes(doctorSpecialty);

                }

                else if(specialty.equals("X-Ray"))
                {
                    xrayType = countingPatientTypes(doctorSpecialty);

                }

                else if(specialty.equals("Emergency"))
                {
                    emergencyType = countingPatientTypes(doctorSpecialty);

                }

            }


        } catch (Exception e) {
            System.out.println(e);
            patientType = null;

        } finally {
            close();
        }

        patientType.add(pediatricianType);
        patientType.add(generalCareType);
        patientType.add(xrayType);
        patientType.add(emergencyType);
        patientType.add(neurologistType);

        return patientType;

    }



    public static String getDate(String dateAndTime) {
        String date = "";
        int position = 0;
        position = dateAndTime.indexOf(" ");

        date = dateAndTime.substring(0, position);

        return date;

    }

    /**
     * get list of alerts
     *
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


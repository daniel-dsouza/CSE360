package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/7/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 *
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */

import org.teamone.core.users.*;

import java.sql.*;

public class LoginSQL {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    public static Person authenticate(Person check) {

        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);

            // PreparedStatements can use variables and are more efficient
            int ID = check.getUserID();
            String pass = check.getPassword();

            preparedStatement = connect.prepareStatement("SELECT userID, name, occupation, password, emailID from person WHERE userID = ?");
            preparedStatement.setInt(1,ID);
            resultSet = preparedStatement.executeQuery();
            if(verify(resultSet, pass))
            {
                //resultSet.next();
                String occ = resultSet.getString("occupation");
               if(occ.equals("patient"))
               {
                   check = new Patient();
               }else
                if(occ.equals("doctor"))
                {
                    check = new Doctor();
                }else
                if(occ.equals("hsp"))
                {
                    check = new HSP();
                }
                else
                if(occ.equals("labstaff"))
                {
                    check = new LabStaff();
                }
                else
                {
                    check = new Person();
                }
                check.setName(resultSet.getString("name"));
                check.setOccupation(resultSet.getString("occupation"));
                check.setEmail(resultSet.getString("emailID"));
                check.setUserID(ID);

            }
            else
                check = null;

        } catch (Exception e) {
            System.out.println(e);
            check = null;
        } finally {
            close();
        }
        return check;

    }


    public static String getName(int patientID) {

        String username;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);


            preparedStatement = connect.prepareStatement("SELECT name from person WHERE userID = ?");
            preparedStatement.setInt(1,patientID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            username = resultSet.getString("name");
            System.out.println("Received User id: " + patientID);
            System.out.println("The Name is: " + username);



        } catch (Exception e) {
            System.out.println(e);
            username = null;
        } finally {
            close();
        }
        return username;

    }

    public static int getID(String patientName) {

        int userID;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);
            preparedStatement = connect.prepareStatement("SELECT userID from person WHERE name = ?");
            preparedStatement.setString(1, patientName);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userID = resultSet.getInt("userID");
            System.out.println("Received name: " + patientName);
            System.out.println("UserID is:" + userID);




        } catch (Exception e) {
            System.out.println(e);
            userID = 0;
        } finally {
            close();
        }
        return userID;

    }


    private static boolean verify(ResultSet resultSet, String pass) throws SQLException {
        // ResultSet is initially before the first data set
        resultSet.next();
        boolean boolResult;
        String passwordSQL = resultSet.getString("password");

        if(pass.compareTo(passwordSQL)==0)
        {
            boolResult = true;
        }
        else
            boolResult = false;
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

        }
    }

}

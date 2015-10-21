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
                   check.setName(resultSet.getString("name"));
                   check.setOccupation(resultSet.getString("occupation"));
                   check.setEmail(resultSet.getString("emailID"));
               }else
                if(occ.equals("doctor"))
                {
                    check = new Doctor();
                    check.setName(resultSet.getString("name"));
                    check.setOccupation(resultSet.getString("occupation"));
                    check.setEmail(resultSet.getString("emailID"));
                }else
                if(occ.equals("hsp"))
                {
                    check = new HSP();
                    check.setName(resultSet.getString("name"));
                    check.setOccupation(resultSet.getString("occupation"));
                    check.setEmail(resultSet.getString("emailID"));
                }
                else
                if(occ.equals("labstaff"))
                {
                    check = new LabStaff();
                    check.setName(resultSet.getString("name"));
                    check.setOccupation(resultSet.getString("occupation"));
                    check.setEmail(resultSet.getString("emailID"));
                }
                else
                {
                    check = new Person();
                    check.setName(resultSet.getString("name"));
                    check.setOccupation(resultSet.getString("occupation"));
                    check.setEmail(resultSet.getString("emailID"));
                }

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
    public static String getName(int userID) {

        String username;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\nTrying to connect to mysql with root and pass");
            connect = DriverManager.getConnection(credentialsSQL.remoteMySQLLocation, credentialsSQL.remoteMySQLuser, credentialsSQL.remoteMySQLpass);


            preparedStatement = connect.prepareStatement("SELECT name from person WHERE userID = ?");
            preparedStatement.setInt(1,userID);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            username = resultSet.getString("name");
            System.out.println("Name is " + username);



        } catch (Exception e) {
            System.out.println(e);
            username = null;
        } finally {
            close();
        }
        return username;

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

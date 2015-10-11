package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/7/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 * http://www.mkyong.com/jdbc/jdbc-preparestatement-example-insert-a-record/
 *
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */

import java.sql.*;

public class MySQL {
    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    boolean isCorrectPerson = false;

    public boolean verify(String userID, String pass) throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nMySQL\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            preparedStatement = connect
                    .prepareStatement("SELECT userID, Password, from person");
            resultSet = preparedStatement.executeQuery();
            boolean isFound = false;
            while (resultSet.next()&& !isFound ) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1
                // e.g. resultSet.getSTring(2);
                //`userID`, `FName`, `LName`, `Occupation`, `Password`, `EmailID`
                String userSQL = resultSet.getString("userID");
                String passwordSQL = resultSet.getString("Password");

                if(userID.compareTo(userSQL) ==0 && pass.compareTo(passwordSQL)==0)
                {
                    isCorrectPerson = true;
                    isFound = true;
                }
                else
                    isCorrectPerson = false;
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            throw e;
        } finally {
            close();
            return isCorrectPerson;
        }

    }


    // You need to close the connections
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
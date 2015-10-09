package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/7/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 *
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nMySQLAccess\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "cse360");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from person");
            writeResultSet(resultSet);

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into person (userID, FName, LName, Occupation, Password, EmailID)"
                            + "values (?, ?, ?, ? , ?, ?)");
            // INSERT INTO `person`(`userID`, `FName`, `LName`, `Occupation`, `Password`, `EmailID`)
            // VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
            // Parameters start with 1
            preparedStatement.setString(1, "Test");
            preparedStatement.setString(2, "TestFirst");
            preparedStatement.setString(3, "TestLast");
            preparedStatement.setString(4, "TestOcc");
            preparedStatement.setString(5, "TestPass");
            preparedStatement.setString(6, "TestEmail@asu.edu");
            preparedStatement.executeUpdate();
            System.out.println("\nUpdated person with new values of testemail@asu.edu\n");
            preparedStatement = connect
                    .prepareStatement("SELECT userID, FName, LName, Occupation, Password, EmailID from person");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            resultSet = statement
                    .executeQuery("select * from person");
            writeMetaData(resultSet);

        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //   Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            //`userID`, `FName`, `LName`, `Occupation`, `Password`, `EmailID`
            String user = resultSet.getString("userID");
            String first = resultSet.getString("FName");
            String last = resultSet.getString("LName");
            String occ = resultSet.getString("Occupation");
            String password = resultSet.getString("Password");
            String email = resultSet.getString("EmailID");
            System.out.println("UserID: " + user);
            System.out.println("First: " + first);
            System.out.println("Last: " + last);
            System.out.println("Occupation: " + occ);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
        }
    }

    // You need to close the resultSet
    private void close() {
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
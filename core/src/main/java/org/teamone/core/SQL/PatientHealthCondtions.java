package org.teamone.core.SQL;

/**
 * Created by Ryan on 10/9/2015.
 * http://www.vogella.com/tutorials/MySQLJava/article.html
 * http://zetcode.com/db/mysqljava/
 *
 * http://makble.com/spring-data-jpa-spring-mvc-and-gradle-integration
 */
import org.teamone.core.Patient;
import org.teamone.core.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientHealthCondtions {
    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;





    public static boolean updateHealthCondition(Patient patient) {
        boolean boolResult;
        try {
            int checker;
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            System.out.println("\n\nTrying to connect to mysql with root and pass\n");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse360", "root", "Abhi1990");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();


            // PreparedStatements can use variables and are more efficient
            int ID = patient.getPatientID();
            String hc = patient.getHealthConditions();

            preparedStatement = connect.prepareStatement("UPDATE patient set healthConditions = ? where patientID = ?");
            preparedStatement.setString(1,hc);
            preparedStatement.setInt(2, ID);
            checker = preparedStatement.executeUpdate();
            if (checker==0)
            boolResult = false;
            else
            boolResult = true;


        } catch (Exception e) {
            System.out.println(e.getStackTrace().toString());
            boolResult = false;
        } finally {
            close();
        }
        return boolResult;

    }

   /* private static boolean verify(ResultSet resultSet, String pass) throws SQLException {
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

        }
    }

}

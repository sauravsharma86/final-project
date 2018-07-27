package db;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVER_LOCATION = "jdbc:mysql://localhost:3306";
    private static final String SCHEMA_NAME = "onlinedrive";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";

    public static java.sql.Connection get() {
        java.sql.Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(
               SERVER_LOCATION + "/" + SCHEMA_NAME, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            System.out.println("SQL Exception : " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFounException : " + ex);
        }
        return connection;
    }
}

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Robante
 */
public class DBConnection {

    private static Connection connection;

    // Initialize and return connection
    public static Connection initializeConnection(String url, String user, String password) throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database connection established.");
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to the database.");
            }
        }
        return connection;
    }

    //get the existing connection
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                return initializeConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe",
                        "plm_register",
                        "plm_register"
                );
            }
        } catch (Exception e) {
            System.out.println("Failed Connection");
        }
        return connection;
        
    }
}

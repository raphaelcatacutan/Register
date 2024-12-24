package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Robante
 */
public class DBConnection {

    // Initialize and return connection
    public static Connection initializeConnection(String url, String user, String password) throws SQLException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database.");
        }
        return connection;
    }

    //get the existing connection
    public static Connection getConnection() {
        try {
            return initializeConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "plm_register",
                    "plm_register"
            );
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

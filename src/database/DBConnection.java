package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DBConnection {

    private static Connection connection;

    // Initialize and return connection
    public static Connection initializeConnection(String url, String user, String password) {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Database connection established.");
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to the database.");
            }
        }
        return connection;
    }

    //get the existing connection
    public static Connection getConnection() {
        if (connection == null) {
            throw new IllegalStateException("Database connection is not initialized.");
        }
        return connection;
    }

    //create the database
    public static void setupDatabase(String tableName) {
        try {
            if (connection == null) {
                throw new IllegalStateException("Database connection is not initialized.");
            }

            Statement statement = connection.createStatement();

            // Check if the table exists
            String checkTableQuery = "SELECT 1 FROM " + tableName + " WHERE ROWNUM = 1";
            try {
                statement.executeQuery(checkTableQuery);
                System.out.println("Table '" + tableName + "' exists.");
            } catch (SQLException e) {
                System.out.println("Table '" + tableName + "' does not exist. Creating table...");
                runSQLFile(statement, "database/sql/Setup.sql");
                System.out.println("Table created successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while setting up the database.");
        }
    }

    private static void runSQLFile(Statement statement, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sql.append(line).append("\n");
            }

            statement.execute(sql.toString());
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to execute SQL file.");
        }
    }
}

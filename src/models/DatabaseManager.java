package models;

import java.sql.*;

public class DatabaseManager {
    private static DatabaseManager databaseManager = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tic_tac_toe?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private static Connection connection = null;
    private static Statement statement = null;

    private DatabaseManager() {
        createConnection();
    }

    /**
     * create only one instance of DatabaseManager
     * @return DatabaseManager instance
     */
    public static DatabaseManager getInstance() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    /**
     * Create connection method
     * @return void
     */
    void createConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * return connection
     * @return Connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * return statement method
     * @return Statement
     */
    public Statement getStatement() {
        return statement;
    }
}


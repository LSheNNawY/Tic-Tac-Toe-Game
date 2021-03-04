package Models;

import java.sql.*;

public final class DatabaseManager {
    private static DatabaseManager databaseManager = null;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tic_tac_toe?serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";
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

    void createConnection() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    /**
     * Login method
     * @param username login username
     * @param password login password
     * @return array of [username, email]
     */
    public String[] login(String username, String password) {
        String[] credentials = {null, null};
        try {
            String query = "SELECT * FROM `players` WHERE `username` = \"" + username + "\" AND `password` = \"" + password + "\" LIMIT 1";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                credentials[0] = resultSet.getString(2);
                credentials[1] = resultSet.getString(3);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return credentials;
    }

    /**
     * Register method
     * @param username player username
     * @param email player email
     * @param password player password
     * @return int 1 if done or 0 if there is error
     */
    public int register(String username, String email, String password) {
        int result = 0;
        try {
            String query = "INSERT INTO `players` (`username`, `email`, `password`) VALUES (\"" + username + "\", \"" + email + "\", \"" + password + "\")";
            statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}


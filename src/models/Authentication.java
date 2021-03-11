package models;

import cutomCollections.PlayerDataCollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Authentication {
    private DatabaseManager instance;
    private Statement statement;
    private Connection connection;

    public Authentication() {
        instance = DatabaseManager.getInstance();
        statement = instance.getStatement();
        connection = instance.getConnection();
    }

    /**
     * Login method
     * @param username login username
     * @param password login password
     * @return array of [username, email]
     */
    public PlayerDataCollection login(String username, String password) {
        PlayerDataCollection playerData = new PlayerDataCollection();
        try {
            String query = "SELECT * FROM `players` WHERE `username` = \"" + username + "\" AND `password` = \"" + password + "\" LIMIT 1";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                playerData.setId(resultSet.getInt(1));
                playerData.setUsername(resultSet.getString(2));
                playerData.setEmail(resultSet.getString(3));
                playerData.setScore(resultSet.getString(5));
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return playerData;
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

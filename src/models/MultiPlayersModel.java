package models;

import cutomCollections.PlayerDataCollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MultiPlayersModel {
    private DatabaseManager instance;
    private Connection connection;
    private Statement statement;

    public MultiPlayersModel() {
        this.instance = DatabaseManager.getInstance();
        this.connection = instance.getConnection();
        this.statement = instance.getStatement();
    }

    public PlayerDataCollection getPlayerData(int id) {
        PlayerDataCollection player = new PlayerDataCollection();
        String query = "SELECT * FROM `players` WHERE `id` = " + id + " LIMIT 1";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                player.setId(resultSet.getInt(1));
                player.setUsername(resultSet.getString(2));
                player.setEmail(resultSet.getString(3));
                player.setScore(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }
}

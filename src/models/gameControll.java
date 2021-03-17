package models;

import cutomCollections.PlayerDataCollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gameControll {
    private DatabaseManager instance;
    private Statement statement;
    private Connection connection;

    public gameControll() {
        instance = DatabaseManager.getInstance();
        statement = instance.getStatement();
        connection = instance.getConnection();
    }


    public boolean setScore(int id, String username, int score) {
        boolean updated = false;
        try {
            String query = "UPDATE players SET `score` =" + (score + 1) + " WHERE `id` = \"" + id + "\" AND `username`=\"" + username + "\"";

            statement = connection.createStatement();
            if (statement.executeUpdate(query) == 1) {
                updated = true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return updated;
    }

    public int checkGameFair(int gameId) {
        int gameCounts = 0;

        try {
            String query = "SELECT count(game_id) FROM `game_moves` WHERE game_id = "+gameId+";";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                gameCounts = resultSet.getInt(1);

            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return gameCounts;
    }

    public boolean setWinner(int winnerId, int gameId) {
        boolean updated = false;
        try {
            String query = "UPDATE `games` SET `winner`="+winnerId+",`status`='win' WHERE id = "+gameId+";";

            statement = connection.createStatement();
            if (statement.executeUpdate(query) == 1) {
                updated = true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return updated;
    }



    public boolean setGame(int player1_id) {
        boolean result = false;
        try {
            String queryy = "INSERT INTO games (`player_1`, `player_2`) VALUES (" + player1_id + ",1)";
            statement = connection.createStatement();
            if (statement.executeUpdate(queryy) == 1) {
                return result;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public boolean setMovementData(int game_id, int player_id, int move_id) {
        boolean result = false;
        try {
            String queryy = "INSERT INTO `game_moves`(`game_id`, `player_id`, `move_id`) VALUES ("+game_id+","+player_id+","+move_id+")";
            statement = connection.createStatement();
            if (statement.executeUpdate(queryy) == 1) {
                return result;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public int getLastGame() {
        int gameId = 0;

        try {
            String query = "SELECT id FROM games ORDER BY id DESC LIMIT 1";

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                gameId = resultSet.getInt(1);
               
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return gameId;
    }


    public boolean gameMovement(int player_id, int move_id) {
        boolean stat_result = false;
        try {
            String queryy = "INSERT INTO game_moves (`player_id`, `move_id` ) VALUES ("+player_id+","+ move_id +")";
            statement = connection.createStatement();
            if (statement.executeUpdate(queryy) == 1){
                return stat_result;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return stat_result;
    }

    public boolean getCurrentGame() {
        boolean res = false;
        try {
            String que = "SELECT * FROM games ORDER BY id DESC LIMIT 1";
            statement = connection.createStatement();
            if (statement.executeUpdate(que) == 1){
                return res;
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return res;
    }





}
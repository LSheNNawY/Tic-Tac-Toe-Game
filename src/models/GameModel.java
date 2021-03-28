package models;

//import cutomCollections.GameMovesDataCollection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class GameModel {
    private Statement statement;
    private final Connection connection;
    public static Vector<String> playersList = new Vector<>();

    public GameModel() {
        DatabaseManager instance = DatabaseManager.getInstance();
        statement = instance.getStatement();
        connection = instance.getConnection();
    }


    public ArrayList<int[]> getGamesByUserId(int user_id) {
       ArrayList<int[]> games = new ArrayList<>();
        try {
            String query = "select `id`, `player_1`, `player_2` from `games` where `player_1` =" + user_id + " OR `player_2` = " + user_id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                games.add(new int[] {resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return games;
    }


    public ArrayList<int[]> getGameMoves(int gameId) {
        ArrayList<int[]> gameMoves = new ArrayList<>();
        try {
            String query = "select `player_id`, `move_id` from `game_moves` where `game_id` =" + gameId + " ORDER BY `created_at`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                gameMoves.add(new int[] {resultSet.getInt(1), resultSet.getInt(2)});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return gameMoves;
    }





    public boolean isOnline(String username) {
        boolean onlineStatus = false;
        try {
            String query = "select `status` from `players` where username = \"" + username + "\"";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next())
                onlineStatus = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return onlineStatus;
    }


    public void setOpeningServer() {
        try {
            String query = "UPDATE `players` set `status`= false and `play_status` = false";
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setPlayerOffline(String username) {
        try {
            String query = "UPDATE `players` set `status`= false WHERE `username` = \"" + username + "\"";
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void setPlayingTrue(String username) {
        try {
            String query = "UPDATE `players` set `play_status`= true WHERE `username` = \"" + username + "\"";
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setPlayingFalse(String username) {
        try {
            String query = "UPDATE `players` set `play_status`= false WHERE `username` = \"" + username + "\"";
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateScore(String username, int score) {
        try {
            String query = "UPDATE `players` set `score`= score WHERE `username` = \"" + username + "\"";
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public String getPlayingPlayersList() {
        String players = null;
        playersList.clear();
        try {
            String query = "SELECT `username` FROM `players` WHERE `status` = true and `play_status` = true";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                playersList.add(resultSet.getString(1));
            }

            for (String s : playersList) {
                if (players == null) {
                    players = "PLIST#" + s;
                } else {
                    players = players + ("#" + s);
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return players;
    }

    public int getScore(String username) {
        int score = 0;
        try {
            String query =  "SELECT `score` from `players` WHERE `username` = \"" +  username + "\"";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                score = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return score;
    }

    public int numOfflinePlayers() {
        int offline = 0;
        try {
            String query = "SELECT * FROM `players` WHERE `status` = false";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ++offline;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return offline;
    }

    public int numOnlinePlayers() {
        int online = 0;
        try {
            String query = "SELECT * FROM `players` WHERE `status` = true";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ++online;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return online;
    }
}

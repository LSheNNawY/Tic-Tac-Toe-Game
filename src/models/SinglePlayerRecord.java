package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SinglePlayerRecord {

    private DatabaseManager instance;
    private Statement statement;
    private Connection connection;

    public SinglePlayerRecord() {
        instance = DatabaseManager.getInstance();
        statement = instance.getStatement();
        connection = instance.getConnection();
    }

    public int createGame(int user_id) {
        int game_id=0,result = 0;
        try {
            String query = "INSERT INTO `games` (`player_1`,`player_2`) VALUES (\"" + user_id + "\" ,\"" + 4 + "\" )";
            statement = connection.createStatement();
            result = statement.executeUpdate(query);

            String anotherQuery = "SELECT id FROM `games` ORDER BY `id` DESC LIMIT 1";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(anotherQuery);

            while (resultSet.next()){
                game_id = resultSet.getInt(1);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return game_id;
    }

    public int storeMove( int game_id , int player_id , int move_id ){
        int result = 0;
        try {
            String query = "INSERT INTO `game_moves` (`game_id`,`player_id`,`move_id`) VALUES (\"" + game_id + "\" ,\"" + player_id + "\",\""+ move_id +"\")";
            statement = connection.createStatement();
            result = statement.executeUpdate(query);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public void setWinner( int winner_id , int game_id ){
        int result = 0;
        try {
            String query = "UPDATE `games` SET `winner` = "+ winner_id +" where id = " + game_id +" ";
            statement = connection.createStatement();
            result = statement.executeUpdate(query);

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return result;
    }


}

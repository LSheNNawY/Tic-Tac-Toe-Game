package client.controllers;

import cutomCollections.PlayerDataCollection;
import javafx.fxml.Initializable;
import models.gameControll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import models.DatabaseManager;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.*;


public class MultiPlayerController extends Component implements Initializable {
    private PlayerDataCollection playerData = Main.playerData;
    @FXML
    private AnchorPane singleRoot;

    @FXML
    private Text playerOneName;

    @FXML
    private Text playerOneScore;

    @FXML
    private Text playerTwoScore;

    @FXML
    private Button sq6;

    @FXML
    private Button sq5;

    @FXML
    private Button sq4;

    @FXML
    private Button sq3;

    @FXML
    private Button sq2;

    @FXML
    private Button sq9;

    @FXML
    private Button sq8;

    @FXML
    private Button sq7;

    @FXML
    private Button sq1;

    @FXML
    private Button backBtn;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    private String startGame = "X";
    public int xCount = Integer.valueOf(playerData.getScore());
    public int oCount = 1;


    private void gameScore() {
        playerOneScore.setText(String.valueOf(xCount));
        playerTwoScore.setText(String.valueOf(oCount));
    }

    private void choose_a_player() {
        if (startGame.equalsIgnoreCase("X")) {
            startGame = "o";

        } else {
            startGame = "X";
        }
    }


    private void winningGame(String game_play, int player, String bgcolor, String state, int width) throws IOException {
        String b1 = sq1.getText();
        String b2 = sq2.getText();
        String b3 = sq3.getText();

        String b4 = sq4.getText();
        String b5 = sq5.getText();
        String b6 = sq6.getText();

        String b7 = sq7.getText();
        String b8 = sq8.getText();
        String b9 = sq9.getText();

        if (b1 == (game_play) && b2 == (game_play) && b3 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq1.setStyle("-fx-color: " + bgcolor + ";");
            sq2.setStyle("-fx-color: " + bgcolor + ";");
            sq3.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);

        }

        if (b4 == (game_play) && b5 == (game_play) && b6 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq4.setStyle("-fx-color: " + bgcolor + ";");
            sq5.setStyle("-fx-color: " + bgcolor + ";");
            sq6.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);


        }

        if (b7 == (game_play) && b8 == (game_play) && b9 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq7.setStyle("-fx-color: " + bgcolor + ";");
            sq8.setStyle("-fx-color: " + bgcolor + ";");
            sq9.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);

        }

        if (b1 == (game_play) && b4 == (game_play) && b7 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq1.setStyle("-fx-color: " + bgcolor + ";");
            sq4.setStyle("-fx-color: " + bgcolor + ";");
            sq7.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);

        }

        if (b2 == (game_play) && b5 == (game_play) && b8 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + "  Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq2.setStyle("-fx-color: " + bgcolor + ";");
            sq5.setStyle("-fx-color: " + bgcolor + ";");
            sq8.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);
        }

        if (b3 == (game_play) && b6 == (game_play) && b9 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq3.setStyle("-fx-color: " + bgcolor + ";");
            sq6.setStyle("-fx-color: " + bgcolor + ";");
            sq9.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);
        }

        if (b3 == (game_play) && b5 == (game_play) && b7 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player  " + game_play + " Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq3.setStyle("-fx-color: " + bgcolor + ";");
            sq5.setStyle("-fx-color: " + bgcolor + ";");
            sq7.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);
        }

        if (b1 == (game_play) && b5 == (game_play) && b9 == (game_play)) {
            player++;
            gameScore();
            JOptionPane.showMessageDialog(this, "Player " + game_play + "  Wins.", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
            sq1.setStyle("-fx-color: " + bgcolor + ";");
            sq5.setStyle("-fx-color: " + bgcolor + ";");
            sq9.setStyle("-fx-color: " + bgcolor + ";");
            updateWinnerScore();
            setGameWinner(game_play);
            Main.setRoot(state);
            Main.setSceneSize(width, 638);


        }
        else{
            gameControll gameFair = new gameControll();
            int lastGameId = gameFair.getLastGame();
            int gameCount = gameFair.checkGameFair(lastGameId);
            System.out.println(gameCount + " => game-count");
            if(gameCount == 8){
                JOptionPane.showMessageDialog(this, "The game is equivalent", "Tic-Tac-Toc", JOptionPane.INFORMATION_MESSAGE);
                Main.setRoot("fair");
                Main.setSceneSize(1083, 638);
            }

        }


    }

    public void setGameWinner(String winner) throws IOException {
        gameControll game = new gameControll();
        if(winner == "X"){
            int winnerId = Main.playerData.getId();
            int gameId = game.getLastGame();
            game.setWinner(winnerId, gameId);
        }else if (winner == "o"){
            int winnerId = 1;
            int gameId = game.getLastGame();
            game.setWinner(winnerId, gameId);
        }
    }

    public void updateWinnerScore() {
        gameControll game = new gameControll();
        boolean updated = game.setScore(playerData.getId(), playerData.getUsername(), Integer.parseInt(playerData.getScore()));
        if(updated){
            int newScore = Integer.parseInt(playerData.getScore())+1;
            Main.playerData.setScore(String.valueOf(newScore));
            playerOneScore.setText(String.valueOf(newScore));
//            Main.setRoot("winner");
//            Main.setSceneSize(1083, 638);
        }
    }

    private void resetAction() {
        sq1.setText(null);
        sq2.setText(null);
        sq3.setText(null);
        sq4.setText(null);
        sq5.setText(null);
        sq6.setText(null);
        sq7.setText(null);
        sq8.setText(null);
        sq9.setText(null);
    }

    private void getMoveData(Button button){
        gameControll gameMove = new gameControll();
        int gameId = gameMove.getLastGame();

        if (button.getText().equals("X")) {
            int playerId = Main.playerData.getId();
            int moveId = Integer.parseInt(button.getId().substring(button.getId().length() - 1));  // sq1
            gameMove.setMovementData(gameId, playerId, moveId);
            System.out.println(gameId + playerId +moveId);
        }
        else if (button.getText().equals("o")) {
            int guestId = 1;
            int movId = Integer.parseInt(button.getId().substring(button.getId().length() - 1));
            gameMove.setMovementData(gameId, guestId, movId);
            System.out.println(gameId + guestId + movId);
        }

    }


    public void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
    }



    public void mouseClicked(MouseEvent mouseEvent) throws IOException {

        Object node = mouseEvent.getSource();
        Button button = (Button) node;
        String id = button.getId();


        switch (id) {
            case "sq1":
                sq1.setText(startGame);
//
                choose_a_player();
                if (sq1.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }
                sq1.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq2":
                sq2.setText(startGame);
//
                choose_a_player();
                if (sq2.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq2.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq3":
                sq3.setText(startGame);
//
                choose_a_player();
                if (sq3.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq3.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq4":
                sq4.setText(startGame);
//
                choose_a_player();
                if (sq4.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq4.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq5":
                sq5.setText(startGame);
//
                choose_a_player();
                if (sq5.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq5.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq6":
                sq6.setText(startGame);
//
                choose_a_player();
                if (sq6.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq6.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq7":
                sq7.setText(startGame);
//
                choose_a_player();
                if (sq7.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq7.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq8":
                sq8.setText(startGame);
//
                choose_a_player();
                if (sq8.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq8.setDisable(true);
                getMoveData((Button) node);
                break;
            case "sq9":
                sq9.setText(startGame);
//
                choose_a_player();
                if (sq9.getText().equals("X")) {
                    winningGame("X", xCount, "pink", "winner", 1083);
                } else {
                    winningGame("o", oCount, "cyan", "loser", 815);
                }

                sq9.setDisable(true);
                getMoveData((Button) node);
                break;
            default:
                break;
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerOneName.setText(Main.playerData.getUsername());
        playerOneScore.setText(Main.playerData.getScore());

        Date date=java.util.Calendar.getInstance().getTime();

        int user_id = Main.playerData.getId();

        gameControll game = new gameControll();
//        boolean updated = game.setGame(user_id, 3, 0, "win", date );
          boolean updated = game.setGame(user_id);

        if(updated){
            System.out.println("true");
        }

        }
}

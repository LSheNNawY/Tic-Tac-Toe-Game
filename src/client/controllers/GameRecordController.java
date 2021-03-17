package client.controllers;

import cutomCollections.PlayerDataCollection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import models.GameModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameRecordController implements Initializable {
    private PlayerDataCollection player;
    private PlayerDataCollection enemy;
    private ArrayList<int[]> gameMoves;

    @FXML
    private Text playerOneName, playerTwoName;

    @FXML
    private Text playerOneScore, playerTwoScore;

    @FXML
    private Button sq6, sq5, sq4, sq3, sq2, sq9, sq8, sq7, sq1;

    @FXML
    private Button backBtn;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
        Main.stage.setResizable(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int gameId = Main.gameHistoryId;
        GameModel model = new GameModel();
        gameMoves = model.getGameMoves(gameId);
        player = Main.playerData;
        playerOneName.setText(player.getUsername());
        playerOneScore.setText(player.getScore());

        if (gameMoves.get(0)[0] == 2 || gameMoves.get(1)[0] == 2) {
            playerTwoName.setText("Cpu");
        } else {
            playerTwoName.setText("Guest");
        }

        new Thread(() -> {
            for (int[] move : gameMoves) {
                int playerId = move[0];
                int moveId = move[1];
                String symbol = (playerId == player.getId()) ? "X" : "O";
                String color = (playerId == player.getId()) ? "red" : "blue";

                Platform.runLater(() -> {
                    switch (moveId) {
                        case 1:
                            sq1.setText(symbol);
                            sq1.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 2:
                            sq2.setText(symbol);
                            sq2.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 3:
                            sq3.setText(symbol);
                            sq3.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 4:
                            sq4.setText(symbol);
                            sq4.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 5:
                            sq5.setText(symbol);
                            sq5.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 6:
                            sq6.setText(symbol);
                            sq6.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 7:
                            sq7.setText(symbol);
                            sq7.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 8:
                            sq8.setText(symbol);
                            sq8.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        case 9:
                            sq9.setText(symbol);
                            sq9.setStyle("-fx-text-fill: " + color + ";-fx-background-color: transparent");
                            break;
                        default:
                            break;
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

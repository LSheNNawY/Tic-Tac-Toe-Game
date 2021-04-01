package client.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import models.GameModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {
    public ArrayList<int[]> games;
    public VBox cpuBox1, guestBox1, cpuBox2, guestBox2;
    public Button backBtn;
    @FXML
    private AnchorPane cpuHistory, guestHistory;

    @FXML
    private void backAction(ActionEvent actionEvent) throws IOException {
        System.out.println("Clicked");
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
        Main.stage.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(backBtn.getOnAction().getClass());

        GameModel model = new GameModel();
        games = model.getGamesByUserId(Main.playerData.getId());
        cpuBox1.maxHeightProperty().bind(cpuBox1.heightProperty());
        guestBox1.maxHeightProperty().bind(guestBox1.heightProperty());
        cpuBox1.setSpacing(5);
        guestBox2.setSpacing(5);
        cpuBox2.maxHeightProperty().bind(cpuBox1.heightProperty());
        guestBox2.maxHeightProperty().bind(guestBox1.heightProperty());
        cpuBox1.setSpacing(5);
        guestBox2.setSpacing(5);
        int cpuCounter = 0;
        int guestCounter = 0;
        for (int[] game : games) {
            int id = game[0];
            int player_1 = game[1];
            int player_2 = game[2];
            Button btn = new Button();
            btn.setId(String.valueOf(id));
          
            btn.setText("Show");

            btn.getStyleClass().add("gameBtn");

            btn.setOnAction(new EventHandler() {
                @Override
                public void handle(Event event) {
                    Main.gameHistoryId = id;
                    try {
                        Main.setRoot("gameRecord");
                        Main.setSceneSize(1083, 778);
                        Main.stage.setResizable(false);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            if (player_1 == 2 || player_2 == 2) {
                if (cpuCounter < 5)
                    cpuBox1.getChildren().add(btn);
                else
                    cpuBox2.getChildren().add(btn);

                cpuCounter++;
            } else if (player_1 == 1 || player_2 == 1) {
                if (guestCounter < 5)
                    guestBox1.getChildren().add(btn);
                else
                    guestBox2.getChildren().add(btn);

                guestCounter++;
            }

        }
    }
}

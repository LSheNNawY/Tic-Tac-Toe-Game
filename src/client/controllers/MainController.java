package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import cutomCollections.PlayerDataCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import models.gameControll;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class MainController implements Initializable {
    public static PlayerDataCollection playerData;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void exitAction(ActionEvent event) {
        Main.stage.close();
    }

    @FXML
    void multiAction(ActionEvent event) throws IOException {
            Main.setRoot("multiplayer");
            Main.setSceneSize(1083, 778);
            Main.stage.setResizable(false);
    }

//    public void setGames() throws IOException {
////        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
////        LocalDateTime now = LocalDateTime.now();
//
//
////        if(updated){
////            int newScore = Integer.parseInt(playerData.getScore())+1;
////            Main.playerData.setScore(String.valueOf(newScore));
////            playerOneScore.setText(String.valueOf(newScore));
////            Main.setRoot("winner");
////            Main.setSceneSize(1083, 638);
////        }
//    }

    @FXML
    void optionAction(ActionEvent event) {

    }

    @FXML
    void singleAction(ActionEvent event) throws IOException {

        Main.setRoot("singlePlayer");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);

    }

//    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        PlayerDataCollection player;
//       player = Main.playerData;
//       JSONParser parser = new JSONParser();
//      JSONObject playerjson = new JSONObject();
//        playerJson.put("name", player.getUsername());
//        playerJson.put("id", player.getId());
//        playerJson.put("score", player.getScore());
//       playerjson = (JSONObject) parser.parse(String.valueOf(player));
//        System.out.println();
//
    }
}

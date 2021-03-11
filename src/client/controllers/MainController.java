package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cutomCollections.PlayerDataCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
        Main.setRoot("networkMultiPlayers");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @FXML
    void optionAction(ActionEvent event) {

    }

    @FXML
    void singleAction(ActionEvent event) throws IOException {
        Main.setRoot("singlePlayer");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        PlayerDataCollection player;
//        player = Main.playerData;
//        JSONParser parser = new JSONParser();
//        JSONObject playerjson = new JSONObject();
////        playerJson.put("name", player.getUsername());
////        playerJson.put("id", player.getId());
////        playerJson.put("score", player.getScore());
//        playerjson = (JSONObject) parser.parse(String.valueOf(player));
        System.out.println();

    }
}
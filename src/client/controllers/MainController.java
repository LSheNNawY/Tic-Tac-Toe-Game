package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cutomCollections.PlayerDataCollection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MainController implements Initializable {
    public static PlayerDataCollection playerData;
    @FXML
    private ListView<Button> onlineListView;

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
        Main.setRoot("multiPlayer");

        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @FXML
    public void showHistory(ActionEvent actionEvent) throws IOException {
        Main.setRoot("gamesHistory");
        Main.setSceneSize(900, 700);
        Main.stage.setResizable(false);
    }

    @FXML
    void singleAction(ActionEvent event) throws IOException {
        Main.setRoot("singlePlayer");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        PlayerConnectionHandler playerConnectionHandler = new PlayerConnectionHandler();
    }
}

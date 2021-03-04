package controllers;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private JFXButton singlePlayerBtn;

    @FXML
    private JFXButton twoPlayersBtn;

    @FXML
    private JFXButton aboutBtn;

    @FXML
    private JFXButton exitBtn;

    @FXML
    void aboutAction(ActionEvent event) throws IOException {
        Main.setRoot("winner");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @FXML
    void exitAction(ActionEvent event) {
        Main.stage.close();
    }

    @FXML
    void singlePlayerAction(ActionEvent event) throws IOException {
        Main.setRoot("singlePlayer");
        Main.setSceneSize(1083, 778);
        Main.stage.setResizable(false);
    }

    @FXML
    void twoPlayersAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert singlePlayerBtn != null : "fx:id=\"singlePlayerBtn\" was not injected: check your FXML file 'main.fxml'.";
        assert twoPlayersBtn != null : "fx:id=\"twoPlayersBtn\" was not injected: check your FXML file 'main.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'main.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'main.fxml'.";

    }
}
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SinglePlayerController {

    public Text playerOneScore;
    public Text playerTwoScore;
    public Button backBtn;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane singleRoot;

    @FXML
    void initialize() {
        assert singleRoot != null : "fx:id=\"singleRoot\" was not injected: check your FXML file 'singlePlayer.fxml'.";

    }

    public void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(760, 451);

    }
}

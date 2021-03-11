package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class SinglePlayerController {

    public Text playerOneScore;
    public Text playerTwoScore;
    public Button backBtn,  sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9;

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
        Main.setSceneSize(945, 565);

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        Object node = mouseEvent.getSource();
        Button button = (Button) node;
        String id = button.getId();

        switch (id) {
            case "sq1":
                sq1.setText("X");
                break;
            case "sq2":
                sq2.setText("X");
                break;
            case "sq3":
                sq3.setText("O");
                break;
            case "sq4":
                sq4.setText("O");
                break;
            case "sq5":
                sq5.setText("X");
                break;
            case "sq6":
                sq6.setText("O");
                break;
            case "sq7":
                sq7.setText("O");
                break;
            case "sq8":
                sq8.setText("X");
                break;
            case "sq9":
                sq9.setText("O");
                break;
            default:
                break;
        }

    }
}

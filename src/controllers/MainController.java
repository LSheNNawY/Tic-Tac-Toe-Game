package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void exitAction(ActionEvent event) {
        Main.stage.close();
    }

    @FXML
    void multiAction(ActionEvent event) {

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

    @FXML
    void initialize() {

    }
}

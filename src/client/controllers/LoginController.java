package client.controllers;

import cutomCollections.PlayerDataCollection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import models.Authentication;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import java.io.IOException;

public class LoginController {

    private String[] credentials = {null, null};

    public Text errorField;
    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private JFXButton signupBtn;

    @FXML
    void loginFunction(ActionEvent event) throws IOException {
        Authentication authentication = new Authentication();
        PlayerDataCollection player = new PlayerDataCollection();
        player = authentication.login(usernameField.getText(), passwordField.getText());

        if (player.getId() == 0)
            errorField.setText("Wrong credentials.");
        else {
            Main.playerData = player;
            Main.setRoot("main");
            Main.setSceneSize(945, 565);
        }
    }

    @FXML
    void redirectToSignup(ActionEvent event) throws IOException {
        Main.setRoot("register");
    }


}

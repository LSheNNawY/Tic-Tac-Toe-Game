package controllers;

import models.DatabaseManager;
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
        DatabaseManager manager = DatabaseManager.getInstance();
        credentials = manager.login(usernameField.getText(), passwordField.getText());

        if (credentials[0] == null)
            errorField.setText("Wrong credentials.");
        else {
            Main.setRoot("main");
        }
    }

    @FXML
    void redirectToSignup(ActionEvent event) throws IOException {
        Main.setRoot("register");
    }


}

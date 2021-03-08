package client.controllers;

import models.DatabaseManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class RegisterController implements Initializable {

    public Text errorField;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXButton loginBtn;

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        Main.setRoot("login");
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        String usernameF = username.getText();
        String emailF = email.getText();
        String passwordF = password.getText();

        if (usernameF.isEmpty()||emailF.isEmpty()||passwordF.isEmpty()){
            errorField.setText("All fields required.");
        } else {
            DatabaseManager databaseManager = DatabaseManager.getInstance();
            int result = databaseManager.register(usernameF, emailF, passwordF);
            if (result == 1) {
                Main.setRoot("login");
            } else {
                errorField.setText("Error while register, please try again later");
            }
        }

    }
    @FXML
    void initialize() {
        assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'sample.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'sample.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'sample.fxml'.";
        assert registerBtn != null : "fx:id=\"registerBtn\" was not injected: check your FXML file 'sample.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'sample.fxml'.";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


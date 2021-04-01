package client.controllers;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import client.NewNetMultiGame;
import client.network.PlayerConnectionHandler;
import cutomCollections.PlayerDataCollection;
import cutomCollections.SerializableObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class NetworkMultiPlayers implements Initializable {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private int counter = 0;
    private PlayerConnectionHandler playerConnectionHandler;

    @FXML
    public Text playerTwoName, playerOneName;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane singleRoot;

    @FXML
    private Text playerOneScore;

    @FXML
    private Text playerTwoScore;

    @FXML
    private Button sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9;

    @FXML
    private Button backBtn;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
        Main.stage.setResizable(false);
    }

    @FXML
    void mouseClicked(MouseEvent event) {
        int test = 0;
        Object node = event.getSource();
        Button button = (Button) node;
        String id = button.getId();
        checkUser(counter, button);
        counter += 1;
    }

    private void checkUser(int test, Button button) {
        if (test % 2 == 0) {
            button.setText("O");
            button.setTextFill(Color.BLUE);
        }
        else {
            button.setText("X");
            button.setTextFill(Color.RED);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}

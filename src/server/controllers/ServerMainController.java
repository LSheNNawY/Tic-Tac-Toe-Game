package server.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import server.connectionHandlers.ServerConnectionHandler;

public class ServerMainController implements Initializable {
    private ServerConnectionHandler serverConnectionHandler;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton startServer;

    @FXML
    private JFXButton stopServer;

    @FXML
    void startServerAction(ActionEvent event) {

    }

    @FXML
    void stopServerAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

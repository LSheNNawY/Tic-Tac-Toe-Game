package server.controllers;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import server.connectionHandlers.ServerConnectionHandler;

public class ServerMainController implements Initializable {
    @FXML
    private RadioButton btnOn;
    @FXML
    private RadioButton btnOff;
    @FXML
    private Text txtServerStatus;
    @FXML
    private PieChart usersChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

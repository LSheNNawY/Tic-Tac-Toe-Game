package client.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class WinnerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    private final String path = new File("src/client/videos/fair.mp4").toURI().toString();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
    }

    public void backAction(ActionEvent actionEvent) throws IOException {
        mediaPlayer.stop();
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
        Main.stage.setResizable(false);
    }
}


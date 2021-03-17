package client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoserController implements Initializable {

    private MediaPlayer mediaPlayer;

    public AnchorPane mediaViewContainer;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MediaView mediaView;
    private final String separator = File.separator;
//    private final String path = new File("src/client/videos/loser.mp4").toURI().toString();
      private final String path = new File("D:/ITI-Study/JAVA/java-project/Tic-Tac-Toe-Game/src/client/videos/loser.mp4").toURI().toString();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
    }

    public void backAction(ActionEvent actionEvent) throws IOException {
        mediaPlayer.pause();
        Main.setRoot("main");
        Main.setSceneSize(945, 565);
    }
}


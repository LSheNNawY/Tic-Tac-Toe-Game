package controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

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

    private final String path = new File("src/videos/winner.mp4").toURI().toString();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media(new File(path).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
//        DoubleProperty width = mediaView.fitWidthProperty();
//        DoubleProperty height = mediaView.fitHeightProperty();
//        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
//        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
    }
}


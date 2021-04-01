package client.controllers;

import cutomCollections.PlayerDataCollection;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    static Scene scene;
    static Stage stage;
    public static PlayerDataCollection playerData;
    public static int gameHistoryId;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        scene = new Scene(loadFXML("login"), 800, 534);
        stage.setScene(scene);
        stage.setResizable(false);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static void setSceneSize(double width, double height) {
        stage.setHeight(height);
        stage.setWidth(width);
    }

    public static Parent loadFXML(String fxml) throws IOException {
        String separator = File.separator;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(".." + separator + "views" + separator + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

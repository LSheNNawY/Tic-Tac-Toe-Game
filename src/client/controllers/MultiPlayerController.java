package client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class MultiPlayerController extends Component {



      public Text playerOneScore;
      public Text playerTwoScore;
      public Button sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9;

      private String startGame = "X";
      private int xCount = 0;
      private int oCount = 0;

      private void gameScore () {
          playerOneScore.setText(String.valueOf(xCount));
          playerTwoScore.setText(String.valueOf(oCount));
      }

      private void choose_a_player () {
          if (startGame.equalsIgnoreCase("X")) {
              startGame = "O";

          } else {
              startGame = "X";
          }
      }

      private void winningGame(String game_play, int player, String bgcolor){
          String b1 = sq1.getText();
          String b2 = sq2.getText();
          String b3 = sq3.getText();

          String b4 = sq4.getText();
          String b5 = sq5.getText();
          String b6 = sq6.getText();

          String b7 = sq7.getText();
          String b8 = sq8.getText();
          String b9 = sq9.getText();

          if( b1 == (game_play) && b2 == (game_play) && b3 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq1.setStyle("-fx-color: " + bgcolor + ";");
              sq2.setStyle("-fx-color: " + bgcolor + ";");
              sq3.setStyle("-fx-color: " + bgcolor + ";");

          }

          if( b4 == (game_play) && b5 == (game_play) && b6 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq4.setStyle("-fx-color: " + bgcolor + ";");
              sq5.setStyle("-fx-color: " + bgcolor + ";");
              sq6.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b7 == (game_play) && b8 == (game_play) && b9 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq7.setStyle("-fx-color: " + bgcolor + ";");
              sq8.setStyle("-fx-color: " + bgcolor + ";");
              sq9.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b1 == (game_play) && b4 == (game_play) && b7 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq1.setStyle("-fx-color: " + bgcolor + ";");
              sq4.setStyle("-fx-color: " + bgcolor + ";");
              sq7.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b2 == (game_play) && b5 == (game_play) && b8 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + "  Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq2.setStyle("-fx-color: " + bgcolor + ";");
              sq5.setStyle("-fx-color: " + bgcolor + ";");
              sq8.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b3 == (game_play) && b6 == (game_play) && b9 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq3.setStyle("-fx-color: " + bgcolor + ";");
              sq6.setStyle("-fx-color: " + bgcolor + ";");
              sq9.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b3 == (game_play) && b5 == (game_play) && b7 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player  "+ game_play + " Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq3.setStyle("-fx-color: " + bgcolor + ";");
              sq5.setStyle("-fx-color: " + bgcolor + ";");
              sq7.setStyle("-fx-color: " + bgcolor + ";");
          }

          if( b1 == (game_play) && b5 == (game_play) && b9 == (game_play) ){
              JOptionPane.showMessageDialog(this,"Player "+ game_play + "  Wins.","Tic-Tac-Toc",JOptionPane.INFORMATION_MESSAGE);
              player++;
              gameScore();
              sq1.setStyle("-fx-color: " + bgcolor + ";");
              sq5.setStyle("-fx-color: " + bgcolor + ";");
              sq9.setStyle("-fx-color: " + bgcolor + ";");
          }

      }
    private void resetAction(){
        sq1.setText(null);
        sq2.setText(null);
        sq3.setText(null);
        sq4.setText(null);
        sq5.setText(null);
        sq6.setText(null);
        sq7.setText(null);
        sq8.setText(null);
        sq9.setText(null);
    }





    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane singleRoot;

    @FXML
    void initialize() {
        assert singleRoot != null : "fx:id=\"singleRoot\" was not injected: check your FXML file 'multiPlayer.fxml'.";

    }

    public void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(945, 565);

    }

    public void mouseClicked(MouseEvent mouseEvent) {


        Object node = mouseEvent.getSource();
        Button button = (Button) node;
        String id = button.getId();


        switch (id) {
            case "sq1":
                sq1.setText(startGame);
                sq1.setStyle( "-fx-background-color: black;" );
//                sq1.setStyle("-fx-background-image: url('/src/images/x.jpg')");
//                 if (startGame.equalsIgnoreCase(game_play)) {
//                      sq1.setStyle("-fx-color: green;");
//                 } else {
//                       sq1.setStyle("-fx-color: blue;");
//                 }
                 choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq1.setDisable(true);
                break;
            case "sq2":
                sq2.setText(startGame);
                sq2.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq2.setStyle("-fx-color: green;");
//                } else {
//                    sq2.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq2.setDisable(true);
                break;
            case "sq3":
                sq3.setText(startGame);
                sq3.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq3.setStyle("-fx-color: green;");
//                } else {
//                    sq3.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq3.setDisable(true);
                break;
            case "sq4":
                sq4.setText(startGame);
                sq4.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq4.setStyle("-fx-color: green;");
//                } else {
//                    sq4.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq4.setDisable(true);
                break;
            case "sq5":
                sq5.setText(startGame);
                sq5.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq5.setStyle("-fx-color: green;");
//                } else {
//                    sq5.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq5.setDisable(true);
                break;
            case "sq6":
                sq6.setText(startGame);
                sq6.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq6.setStyle("-fx-color: green;");
//                } else {
//                    sq6.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq6.setDisable(true);
                break;
            case "sq7":
                sq7.setText(startGame);
                sq7.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq7.setStyle("-fx-color: green;");
//                } else {
//                    sq7.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq7.setDisable(true);
                break;
            case "sq8":
                sq8.setText(startGame);
                sq8.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq8.setStyle("-fx-color: green;");
//                } else {
//                    sq8.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq8.setDisable(true);
                break;
            case "sq9":
                sq9.setText(startGame);
                sq9.setStyle( "-fx-background-color: black;" );

//                if (startGame.equalsIgnoreCase(game_play)) {
//                    sq9.setStyle("-fx-color: green;");
//                } else {
//                    sq9.setStyle("-fx-color: blue;");
//                }
                choose_a_player();
                winningGame("X", xCount, "pink");
                winningGame("O", oCount, "cyan");
                sq9.setDisable(true);
                break;
            default:
                break;
        }

    }
}

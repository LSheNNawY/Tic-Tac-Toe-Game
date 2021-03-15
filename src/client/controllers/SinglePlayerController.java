package client.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import cutomCollections.PlayerDataCollection;
import models.SinglePlayerRecord;

public class SinglePlayerController {

    public Text playerOneScore;
    public Text playerTwoScore;
    public Text playerUsername;
    public Button backBtn,  sq1, sq2, sq3, sq4, sq5, sq6, sq7, sq8, sq9;
    String symbol = "X";
    String player = "user";
    int user_id = Main.playerData.getId();
    int game_id = 0;
    SinglePlayerRecord singlePlayerRecord = new SinglePlayerRecord();

    static ArrayList<String> playerPositions = new ArrayList<String>();
    static ArrayList<String> cpuPositions = new ArrayList<String>();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane singleRoot;

    @FXML
    void initialize() {
        assert singleRoot != null : "fx:id=\"singleRoot\" was not injected: check your FXML file 'singlePlayer.fxml'.";
        showPlayerName();
        showPlayerScore();
        clearBoard();
        game_id = singlePlayerRecord.createGame(user_id);
        String score = Main.playerData.getScore();

        // To Be Moved

       // singlePlayerRecord.storeMove(game_id,user_id,1);
    }

    public void backAction(ActionEvent event) throws IOException {
        Main.setRoot("main");
        Main.setSceneSize(945, 565);

    }

    public void mouseClicked(MouseEvent mouseEvent) {
        Object node = mouseEvent.getSource();
        Button button = (Button) node;
        String playerPosition = button.getId();

        player = "user";
        drawSymbol(playerPosition);
        playerPositions.add(playerPosition);
        System.out.println(playerPosition);

        Random rand = new Random();
        String cpuPosition = "sq" + String.valueOf(rand.nextInt(9) + 1);

        while (cpuPositions.contains(cpuPosition) || playerPositions.contains(cpuPosition) ){
            cpuPosition = "sq" + String.valueOf(rand.nextInt(9) + 1);
        }

        System.out.println(cpuPosition);
        player = "cpu";
        drawSymbol(cpuPosition);
        cpuPositions.add(cpuPosition);

        checkWinner();





        //System.out.println(button);
        button.setDisable(true);
    }

    public void clearBoard(){
        sq1.setText("");
        sq2.setText("");
        sq3.setText("");
        sq4.setText("");
        sq5.setText("");
        sq6.setText("");
        sq7.setText("");
        sq8.setText("");
        sq9.setText("");
    }

    public void showPlayerName(){
        String name = Main.playerData.getUsername();
        playerUsername.setText(name);
    }

    public void showPlayerScore(){
        String score = Main.playerData.getScore();
        playerOneScore.setText(score);
    }

    public  void drawSymbol(String positionID){
        checkPlayer();
        switch (positionID) {
            case "sq1":
                sq1.setText(symbol);
                break;
            case "sq2":
                sq2.setText(symbol);
                break;
            case "sq3":
                sq3.setText(symbol);
                break;
            case "sq4":
                sq4.setText(symbol);
                break;
            case "sq5":
                sq5.setText(symbol);
                break;
            case "sq6":
                sq6.setText(symbol);
                break;
            case "sq7":
                sq7.setText(symbol);
                break;
            case "sq8":
                sq8.setText(symbol);
                break;
            case "sq9":
                sq9.setText(symbol);
                break;
            default:
                break;
        }
    }

    public void checkPlayer(){
        if (player.equals("user")){
            symbol = "X";
        }
        else{
            symbol = "0";
        }
    }


    public String checkWinner(){

        List topRow = Arrays.asList("sq1","sq2","sq3");
        List midRow = Arrays.asList("sq4","sq5","sq6");
        List bottomRow = Arrays.asList("sq7","sq8","sq9");
        List leftCol = Arrays.asList("sq1","sq4","sq7");
        List midCol = Arrays.asList("sq2","sq5","sq8");
        List rightCol = Arrays.asList("sq3","sq6","sq9");
        List cross1 = Arrays.asList("sq1","sq5","sq9");
        List cross2 = Arrays.asList("sq7","sq5","sq3");

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(bottomRow);
        winningConditions.add(leftCol);
        winningConditions.add(rightCol);
        winningConditions.add(midCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);



        for ( List l : winningConditions ){
            if(playerPositions.containsAll(l)){
                System.out.println("You Won");
            }
            else  if (playerPositions.containsAll(l)){
                System.out.println("cpu Wins :( ");
            }
        }
        return "";
    }


}

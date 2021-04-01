package cutomCollections;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMovesDataCollection implements Serializable {
    private int PlayerId;
    private ArrayList<int[]> gameMoves;

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int playerId) {
        PlayerId = playerId;
    }


    public ArrayList<int[]> getGameMoves() {
        return gameMoves;
    }

    public void setGameMoves(ArrayList<int[]> gameMoves) {
        this.gameMoves = gameMoves;
    }
}

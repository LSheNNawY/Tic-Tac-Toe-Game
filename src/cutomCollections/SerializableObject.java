package cutomCollections;

import java.io.Serializable;

public class SerializableObject implements Serializable {
    public String squareId;
    public int playerId;

    public SerializableObject(String squareId, int playerId) {
        this.squareId = squareId;
        this.playerId = playerId;
    }
}

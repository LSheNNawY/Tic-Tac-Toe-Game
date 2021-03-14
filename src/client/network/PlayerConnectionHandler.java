package client.network;
import cutomCollections.SerializableObject;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


// player connection
public class PlayerConnectionHandler {
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private int yourId;

    public PlayerConnectionHandler(int yourId) {
        this.yourId = yourId;
        System.out.println("--------- New Player---------");
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9500);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            SerializableObject sendObject = new SerializableObject("haaaaaay square 1", yourId);
            objectOutputStream.writeObject(sendObject);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException from NetworkMultiPlayer-> PlayerConnection inner class constructor");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("IOException from networkMultiPlayers finally clause");
            }
        }

    }
}
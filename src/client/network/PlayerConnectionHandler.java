package client.network;
import client.controllers.Main;
import cutomCollections.PlayerDataCollection;
import cutomCollections.SerializableObject;
import javafx.scene.control.Button;

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

    public PlayerConnectionHandler() {
        System.out.println("--------- New Player---------");
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 9500);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(Main.playerData);

            new Thread(() -> {
                PlayerDataCollection newPlayer;
                try {
                    newPlayer = (PlayerDataCollection) objectInputStream.readObject();
                    System.out.println(newPlayer.getUsername());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException from NetworkMultiPlayer-> PlayerConnection inner class constructor");
        }

    }
}
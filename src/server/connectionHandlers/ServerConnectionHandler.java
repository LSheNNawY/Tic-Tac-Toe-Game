package server.connectionHandlers;

import client.controllers.Main;
import cutomCollections.PlayerDataCollection;
import cutomCollections.SerializableObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerConnectionHandler {
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    public Vector<ServerConnectionHandler> connectedSockets = new Vector<ServerConnectionHandler>();
    public static ObservableList<PlayerDataCollection> onlinePlayers = FXCollections.observableArrayList();

    private int connectionsNumber = 0;
    private int firstPlayerId;
    private int secondPlayerId;

    public ServerConnectionHandler() {
        acceptConnections();
    }

    public void acceptConnections() {
        System.out.println("--------------- Server started ------------");
        try {
            serverSocket = new ServerSocket(9500);
            System.out.println(" waiting for players.............");

            new Thread(() -> {
                while (true) {
                    try {
                        socket = serverSocket.accept();

                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectInputStream = new ObjectInputStream(socket.getInputStream());
                        connectionsNumber += 1;
                        connectedSockets.add(this);
                        System.out.println("New Player");
                        onlinePlayers.add((PlayerDataCollection) objectInputStream.readObject());

                        for (PlayerDataCollection player : onlinePlayers) {
                            System.out.println(player.getUsername());
                            objectOutputStream.writeObject(player);
                        }
                        objectOutputStream.flush();

                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                        System.out.println("IOException from ServerConnectionHandler thread in acceptConnection method");
                    }
                }

            }).start();
        } catch (IOException e) {
            System.out.println("IOException from ServerHandler acceptConnection");
        }
    }


}

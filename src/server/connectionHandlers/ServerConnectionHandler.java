package server.connectionHandlers;

import cutomCollections.SerializableObject;

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
                        Socket socket = serverSocket.accept();

                        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        objectInputStream = new ObjectInputStream(socket.getInputStream());
                        connectionsNumber += 1;
                        connectedSockets.add(this);
                        System.out.println("New Player");
                        // send ids for players
                        if (connectionsNumber == 1) {
//                            firstPlayerId = dataInputStream.readInt();
                            SerializableObject recievedObj = (SerializableObject) objectInputStream.readObject();
                            firstPlayerId = recievedObj.playerId;
                            System.out.println("first Player id #" + firstPlayerId);
                            objectOutputStream.flush();

                        } else if (connectionsNumber == 2) {
                            SerializableObject recievedObj = (SerializableObject) objectInputStream.readObject();
                            secondPlayerId = recievedObj.playerId;
                            objectOutputStream.flush();
                        }
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

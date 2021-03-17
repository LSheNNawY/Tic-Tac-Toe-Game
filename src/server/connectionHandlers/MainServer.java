package server.connectionHandlers;
import models.DatabaseManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer extends Thread {

    public static ServerSocket mainSocket;
    private DatabaseManager dbConnection;
    private static MainServer mainServerObject;

    private MainServer() {
        try {
            mainSocket = new ServerSocket(9500);
            dbConnection = DatabaseManager.getInstance();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static MainServer getInstance() {
        if (mainServerObject == null) {
            mainServerObject = new MainServer();
        }
        return mainServerObject;
    }

    public static void deleteInstance() {
        mainServerObject = null;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket s = mainSocket.accept();
                new GameHandler(s);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void stopClients() throws IOException {  //stops clients when closing server
        for (GameHandler s : GameHandler.clientVector) {
            s.clientSocket.close();
            s.ps.close();
            s.dis.close();
            s.stop();
        }
        GameHandler.clientVector.removeAllElements();
    }
}

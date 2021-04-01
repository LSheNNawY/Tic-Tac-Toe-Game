package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class NewNetMultiGame {
    Socket server;
    DataInputStream dis;
    PrintStream ps;

    public NewNetMultiGame() {
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            server = new Socket(ipAddress, 6000);
            dis = new DataInputStream(server.getInputStream());
            ps = new PrintStream(server.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    String msg = "";
                    try {
                        msg = dis.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

package my.examples.was;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// THREAD 아님!
public class Connector {
    private int port;

    public Connector(int port) {
        this.port = port;
    }

    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (Exception e) {}
        }
    }
}
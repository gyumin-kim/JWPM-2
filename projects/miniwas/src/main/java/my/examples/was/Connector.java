package my.examples.was;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connector extends Thread {
    private int port;

    public Connector(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(this, socket);
                handler.start();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException ie) {}
        }
    }
}

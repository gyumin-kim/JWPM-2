package my.examples.was;

import java.net.Socket;

public class Handler extends Thread {
    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        super.run();
    }
}
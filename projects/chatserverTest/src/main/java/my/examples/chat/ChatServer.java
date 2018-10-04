package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ChatServer는 port와 CopyOnWriteArraySet을 갖는다
 * addPrintWriter, removePrintWriter, broadcast 메소드
 * run()에서는 접속이 발생할 때마다 Socket을 생성하고 Handler에게 넘긴다
 */
public class ChatServer extends Thread {
    private int port;
    private Set<PrintWriter> clientOutputSet = null;

    public ChatServer(int port) {
        this.port = port;
        this.clientOutputSet = new CopyOnWriteArraySet<>();
    }

    public void addPrintWriter(PrintWriter pw) {
        clientOutputSet.add(pw);
    }

    public void removePrintWriter(PrintWriter pw) {
        clientOutputSet.remove(pw);
    }

    public void broadcast(String msg) {
        for (PrintWriter pw : clientOutputSet) {
            pw.println(msg);
            pw.flush();
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                SocketHandler socketHandler = new SocketHandler(this, socket);
                socketHandler.start();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
}
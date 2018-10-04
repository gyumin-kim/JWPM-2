package my.examples.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer extends Thread {
    private int port;   // 서버가 실행되는 port
    private Set<PrintWriter> clientOutputSet = null;    // 접속한 client의 out을 담기 위한 자료구조

    public ChatServer(int port) {
        this.port = port;
        this.clientOutputSet = new CopyOnWriteArraySet<>();
    }

    // 처음 접속시 socketSet에 추가
    public void addPrintWriter(PrintWriter out) {
        clientOutputSet.add(out);
    }

    // 접속이 끊어진 client는 socketSet에서 제거(broadcasting하면 안됨)
    public void removePrintWriter(PrintWriter out) {
        clientOutputSet.remove(out);
    }

    public void broadcast(String msg) {
        for (PrintWriter out : clientOutputSet) {
            try {
                out.println(msg);
                out.flush();
            } catch (Exception ex) {}   // 문제가 생긴 PrintWriter만 아무 것도 하지 않는다
        }
//        System.out.println("broadcast: client들에게 msg 쓴다 (" + clientOutputSet.size() + "명)");
    }

    // 채팅 서버가 해야할 작업을 코딩
    @Override
    public void run() {
        ServerSocket serverSocket = null;

        try {
            // ServerSocket: 네트워크를 통해 해당 port에 요청이 들어오기를 기다린다.
            // port와 binding
            serverSocket = new ServerSocket(port);

            while (true) {
                // client를 기다린다(blocking method)
                // accept(): socket에 들어올 연결을 기다렸다가 수락한다.
                // client가 접속할 때마다 새로운 socket 생성 및 연결
                Socket socket = serverSocket.accept();

                // socket을 가지고 있는 thread를 생성 (즉 client 접속시마다 반복 생성)
                SocketHandler handler = new SocketHandler(this, socket);    // this: 현재 ServerSocket
                handler.start();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                // ServerSocket도 종료되면 반드시 close()
                serverSocket.close();
            } catch (IOException ie) {}
        }
    }
}
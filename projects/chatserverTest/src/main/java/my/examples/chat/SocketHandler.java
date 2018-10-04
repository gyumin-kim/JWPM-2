package my.examples.chat;

import java.io.*;
import java.net.Socket;

/**
 * ChatServer와 Socker을 받는다.
 * socket으로부터 name을 입력받아 addPrintWriter & broadcast한다.
 * 이후 모든 메시지를 broadcast한다.
 */
public class SocketHandler extends Thread {
    private ChatServer chatServer;
    private Socket socket;
    private String name;

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            this.name = br.readLine();
            chatServer.addPrintWriter(pw);
            chatServer.broadcast(this.name + "님이 입장하셨습니다.");

            String line = null;
            while ((line = br.readLine()) != null) {
                chatServer.broadcast(this.name + ")) " + line);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            chatServer.removePrintWriter(pw);
            chatServer.broadcast(this.name + "님이 나갔습니다.");
            pw.close();
            try {
                br.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
    }
}

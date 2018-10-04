package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class SocketHandler extends Thread {
    private ChatServer chatServer;  // SocketHandler가 ChatServer를 가진다
    private Socket socket;
    private String name;    // 각 client에 해당하는 socket이 갖는 이름

    public SocketHandler(ChatServer chatServer, Socket socket) {
        this.chatServer = chatServer;
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("SocketHandler Start");

        // 연결 끊기면 예외 발생
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            // socket에서 뭔가 읽고 쓸 때 exception이 발생할 수 있다
            // in, out: 해당 socket에 읽고(InputStream) 쓸(OutputStream)수 있는 변수
            // 프로그램으로 들어오는 데이터를 Reader(문자기반)로 받겠다
            // Reader로 받은 데이터를 버퍼를 이용해 받아서 성능을 향상(BufferedReader)
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 입장
            this.name = in.readLine();
            chatServer.addPrintWriter(out);
            chatServer.broadcast(this.name + "님이 입장하셨습니다.");

            // 채팅 메시지 입력
            String line = null;
            while ((line = in.readLine()) != null) {
                chatServer.broadcast(this.name + ")) " + line);
            }
        } catch (Exception ex) {
            System.out.println("Chat Handler close");
        } finally {
            // 퇴장
            chatServer.removePrintWriter(out);
            chatServer.broadcast(this.name + "님이 나갔습니다");
            System.out.println("Chat Handler finally");
            try { in.close(); } catch (Exception ie) {ie.printStackTrace();}
            out.close();
        }
    }
}

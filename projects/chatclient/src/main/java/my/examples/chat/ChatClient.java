package my.examples.chat;

import java.io.*;
import java.net.Socket;

public class ChatClient extends Thread {
    private String ip;
    private int port;
    private String name;

    public ChatClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        BufferedReader keyboard = null; // keyboard는 항상 열려있는 장치이므로 close할 필요 없음

        try {
            // socket을 생성하여 연결 요청 (serverSocket.accept()가 trigger됨)
            socket = new Socket(ip, port);

            keyboard = new BufferedReader(new InputStreamReader(System.in));
            // in, out: 해당 socket에 읽고(InputStream) 쓸(OutputStream)수 있는 변수
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("채팅할 이름을 입력하세요.");
            this.name = keyboard.readLine();
            // client가 이름(name)을 보냄
            out.println(name);
            out.flush();
            // server에서는 this.name = in.readLine();로 받음

            // 서버가 보내주는 메시지를 listen하기 위한 handler thread
            InputHandler handler = new InputHandler(in);
            handler.start();

            String line = null;
            while ((line = keyboard.readLine()) != null) {
                if (line.equals("/quit"))    break;
                // client가 메시지를 보냄
                out.println(line);
                out.flush();
                // server에서는 line = in.readLine()로 받음
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ie) {}
            try {
                in.close();
            } catch (IOException ie) {}
            out.close();
        }
    }
}

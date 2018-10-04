package my.examples.chat;

import java.io.*;
import java.net.Socket;

/**
 * ChatClient는 ip, port, name을 갖는다.
 * 키보드로부터 채팅할 이름을 입력받아 서버에게 전송한다.
 * 그 다음줄부터 입력받은 줄마다 전부 서버에게 전송한다.
 * 서버로부터 오는 메시지를 듣기 위한 InputHandler에게 BufferedReader를 전달하고 start한다.
 */
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
        BufferedReader br = null;
        PrintWriter pw = null;
        BufferedReader keyboard = null;

        try {
            socket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            keyboard = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("채팅할 이름을 입력하세요.");
            name = keyboard.readLine();
            pw.println(name);
            pw.flush();

            InputHandler inputHandler = new InputHandler(br);
            inputHandler.start();

            String line = null;
            while ((line = br.readLine()) != null) {
                if ("/quit".equals(line))   break;
                pw.println(line);
                pw.flush();
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {

        }
    }
}

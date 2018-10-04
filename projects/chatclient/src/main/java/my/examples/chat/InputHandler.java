package my.examples.chat;

import java.io.BufferedReader;
import java.io.IOException;

// 서버가 보내주는 메시지를 백그라운드에서 읽어들여 화면에 출력.
public class InputHandler extends Thread {
    BufferedReader in;

    public InputHandler(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String line = null;
            while ((line = in.readLine()) != null) {    // null이라는 것은 네트워크 끊어졌다는 의미 (socket.close())
//                System.out.println("ChatServer.broadcast(line 32-33에서 msg 읽어옴)");
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException ie) {}
        }
    }
}

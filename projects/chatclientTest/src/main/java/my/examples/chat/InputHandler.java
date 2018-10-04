package my.examples.chat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 서버가 보내주는 메시지를 백그라운드에서 받기 위한 handler
 * ChatClient에서 받은 BufferedReader로 매 줄을 입력받아 콘솔에 출력한다.
 */
public class InputHandler extends Thread {
    private BufferedReader br;

    public InputHandler(BufferedReader br) {
        this.br = br;
    }

    @Override
    public void run() {
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}

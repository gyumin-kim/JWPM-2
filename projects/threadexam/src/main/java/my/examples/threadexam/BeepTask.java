package my.examples.threadexam;

import java.awt.*;

public class BeepTask implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);  // 0.5초 간 일시정지
            } catch (Exception e) {}
        }
    }
}

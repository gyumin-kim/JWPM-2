package my.examples.threadexam;

import java.awt.*;

public class BeepPrintExample1 {
    public static void main(String[] args) {
        // 메인 스레드만 사용
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);  // 0.5초 간 일시정지
            } catch (Exception e) {}
        }

        // beep을 전부 실행하고 나서 다음을 실행
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);  // 0.5초 간 일시정지
            } catch (Exception e) {}
        }
    }
}

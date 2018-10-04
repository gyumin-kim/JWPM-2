package my.examples.threadexam;

import java.awt.*;

public class BeepPrintExample3 {
    public static void main(String[] args) {
        // Thread를 상속받는 BeepThread의 객체를 생성 후 start() 호출
//        Thread thread = new BeepThread();
//        thread.start();

        // Thread 익명 객체를 이용하는 방법
        Thread thread1 = new Thread() {
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
        };
        thread1.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);  // 0.5초 간 일시정지
            } catch (Exception e) {}
        }
    }
}
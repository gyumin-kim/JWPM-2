package my.examples.threadexam;

import java.awt.*;

public class BeepPrintExample2 {
    // 메인 스레드 시작
    public static void main(String[] args) {
        // 가장 기본적인 방법
//        Runnable beepTask = new BeepTask();
//        Thread thread = new Thread(beepTask);
//        thread.start(); // 작업 스레드 시작

        // 익명 객체를 이용하는 방법
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Toolkit toolkit = Toolkit.getDefaultToolkit();
//                for (int i = 0; i < 5; i++) {
//                    toolkit.beep();
//                    try {
//                        Thread.sleep(500);  // 0.5초 간 일시정지
//                    } catch (Exception e) {}
//                }
//            }
//        });
//        thread1.start();

        // 람다식을 이용하는 방법
        Thread thread2 = new Thread(() -> {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                try {
                    Thread.sleep(500);  // 0.5초 간 일시정지
                } catch (Exception e) {}
            }
        });
        thread2.start();

        // 메인 스레드에서 할 일
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);  // 0.5초 간 일시정지
            } catch (Exception e) {}
        }
    }
}

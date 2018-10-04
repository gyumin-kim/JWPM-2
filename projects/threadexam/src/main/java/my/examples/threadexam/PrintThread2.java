package my.examples.threadexam;

public class PrintThread2 extends Thread {
    @Override
    public void run() {
        // Thread.sleep(1)으로 고의적으로 일시정지 시킴
//        try {
//            while (true) {
//                System.out.println("실행 중");
//                Thread.sleep(1);
//            }
//        } catch (WorkThread ie) {}

        while (true) {
            System.out.println("실행 중");
            if (Thread.interrupted())
                break;
        }
        System.out.println("자원 정리");
        System.out.println("실행 종료");
    }
}

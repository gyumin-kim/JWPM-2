package my.examples.threadexam;

public class WorkObject {
    // ThreadA가 작업할 내용
    public synchronized void methodA() {
        System.out.println("ThreadA의 methodA() 작업 실행");
        notify();   // 다른 스레드를 실행 대기 상태로 만든다. (실행 가능한 상태로)
        try {
            wait(); // 이 스레드를 일시정지 상태로 만든다.
        } catch (InterruptedException ie) {}
    }

    // ThreadB가 작업할 내용
    public synchronized void methodB() {
        System.out.println("ThreadB의 methodB() 작업 실행");
        notify();   // 다른 스레드를 실행 대기 상태로 만든다. (실행 가능한 상태로)
        try {
            wait(); // 이 스레드를 일시정지 상태로 만든다.
        } catch (InterruptedException ie) {}
    }
}

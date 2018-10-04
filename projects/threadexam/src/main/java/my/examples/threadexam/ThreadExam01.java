package my.examples.threadexam;

/**
 * Thread를 상속받는 MyThread01 class를 생성하고, run()을 오버라이딩한다.
 * run()에서는 MyThread02가 필드로 갖고 있는 string을 1초마다 출력한다. (1초마다 Thread.sleep() 호출)
 * main 메소드에서 Thread의 .start()를 호출한다.
 */
public class ThreadExam01 {
    public static void main(String[] args) {
        MyThread01 m1 = new MyThread01("*");
        MyThread01 m2 = new MyThread01("-");
        MyThread01 m3 = new MyThread01("#");
        m1.start();
        m2.start();
        m3.start();
        System.out.println("main method 종료");
    }
}

class MyThread01 extends Thread {
    private String str;
    public MyThread01(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print(str);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException ex) {}
        }
    }
}

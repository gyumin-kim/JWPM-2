package my.examples.threadexam;

/**
 * Runnable interface를 구현한 MyThread02 class를 생성하고, Thread class가 MyThread02를 갖도록 한다.
 * run()에서는 MyThread02가 필드로 갖고 있는 string을 1초마다 출력한다. (1초마다 Thread.sleep() 호출)
 * main 메소드에서 Thread의 .start()를 호출한다.
 */
public class ThreadExam02 {
    public static void main(String[] args) {
        MyThread02 m1 = new MyThread02("*");
        MyThread02 m2 = new MyThread02("#");
        MyThread02 m3 = new MyThread02("&");
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        Thread t3 = new Thread(m3);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main 메소드 종료");
    }
}

class MyThread02 implements Runnable {
    private String str;

    public MyThread02(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.print(str);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException ie) {}
        }
    }
}
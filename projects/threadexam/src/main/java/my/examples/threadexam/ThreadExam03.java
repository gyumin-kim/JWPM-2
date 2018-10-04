package my.examples.threadexam;

/**
 * Thread를 상속받는 MyThread03 class를 생성하고, run()을 오버라이딩한다.
 * MyThread03은 flag(int)와, MyData라는 공유 객체를 갖는다.
 * MyData class는 print1, print2, print3 메소드만 갖는다.
 * run()에서는 MyThread03의 flag 값에 따라 MyData의 각각 다른 print()를 호출한다.
 * 3개의 print()에 각각 synchronized 키워드를 붙여본다.
 * main 메소드에서 Thread의 .start()를 호출한다.
 */
public class ThreadExam03 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        Thread t1 = new Thread(new MyThread03(1, myData));
        Thread t2 = new Thread(new MyThread03(2, myData));
        Thread t3 = new Thread(new MyThread03(3, myData));
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThread03 implements Runnable {
    private int flag;
    private MyData myData;

    public MyThread03(int flag, MyData myData) {
        this.flag = flag;
        this.myData = myData;
    }

    @Override
    public void run() {
        if (flag == 1)  myData.print1();
        else if (flag == 2)  myData.print2();
        else if (flag == 3)  myData.print3();
    }
}

class MyData {
    public void print1() {
        for (int i = 0; i < 5; i++) {
            System.out.print("#");
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ie) {}
        }
    }
    public synchronized void print2() {
        for (int i = 0; i < 5; i++) {
            System.out.print("&");
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ie) {}
        }
    }
    public synchronized void print3() {
        for (int i = 0; i < 5; i++) {
            System.out.print("-");
            try {
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ie) {}
        }
    }
}
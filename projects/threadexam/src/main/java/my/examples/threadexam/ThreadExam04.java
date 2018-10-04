package my.examples.threadexam;

public class ThreadExam04 {
    public static void main(String[] args) {
        // 이름 없는 클래스. new A(){ ... }
        // A를 상속받거나, 구현하는 이름 없는 객체를 생성한다.
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++){
                    System.out.print("*");
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
    }
}

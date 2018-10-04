package my.examples.threadexam;

public class ThreadExam05 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++){
                    System.out.print("*");
                }
            }
        });
        t.start();
    }
}

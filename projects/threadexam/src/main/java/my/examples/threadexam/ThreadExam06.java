package my.examples.threadexam;

public class ThreadExam06 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for(int i = 0; i < 50; i++){
                System.out.print("*");
            }
        }, "ㅇㅇ");
        t.start();
    }
}

package my.examples.threadexam;

public class PriorityExample {
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            Thread thread = new CalcThread("thread" + i);
            if (i != 10)
                thread.setPriority(Thread.MIN_PRIORITY);
            else
                thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }
    }
}

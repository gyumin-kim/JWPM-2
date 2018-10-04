package my.examples.threadexam;

public class StopFlagExample {
    public static void main(String[] args) {
        PrintThread1 printThread = new PrintThread1();
        printThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {}

        printThread.setStop(true);
    }
}

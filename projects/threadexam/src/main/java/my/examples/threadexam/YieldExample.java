package my.examples.threadexam;

public class YieldExample {
    public static void main(String[] args) {
        YieldThreadA threadA = new YieldThreadA();
        YieldThreadB threadB = new YieldThreadB();

        threadA.start();
        threadB.start();

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.work = false;

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.work = true;

        try { Thread.sleep(3000); } catch (InterruptedException ie) {}
        threadA.stop = true;
        threadB.stop = true;
    }
}

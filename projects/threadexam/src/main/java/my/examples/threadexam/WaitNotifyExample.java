package my.examples.threadexam;

public class WaitNotifyExample {
    public static void main(String[] args) {
        WorkObject workObject = new WorkObject();

        WaitNotifyThreadA threadA = new WaitNotifyThreadA(workObject);
        WaitNotifyThreadB threadB = new WaitNotifyThreadB(workObject);

        threadA.start();
        threadB.start();
    }
}

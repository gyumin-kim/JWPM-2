package my.examples.threadexam;

public class Calculator {
    private int memory;

    public int getMemory() {
        return memory;
    }

    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {}
        System.out.println(Thread.currentThread().getName() + ": " + this.memory);
    }
}

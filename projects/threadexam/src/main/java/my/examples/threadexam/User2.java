package my.examples.threadexam;

public class User2 extends Thread {
    private Calculator calculator;

    public User2() {
        setName("User2 Thread");
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        calculator.setMemory(50);
    }
}

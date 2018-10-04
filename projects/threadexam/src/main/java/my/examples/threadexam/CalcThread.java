package my.examples.threadexam;

public class CalcThread extends Thread {
    public CalcThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000000000; i++) {
            int m;
        }
        System.out.println(getName());
    }
}

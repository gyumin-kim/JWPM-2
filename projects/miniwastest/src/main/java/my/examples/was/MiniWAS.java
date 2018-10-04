package my.examples.was;


public class MiniWAS extends Thread {
    @Override
    public void run() {
        Connector connector = new Connector(9000);
        connector.run();
    }
}

package my.examples.was;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector(20000);
        connector.start();

        //TODO: Main, Connector 중 어디에 놓아야 하는가?
        Engine engine = new Engine();
        DefaultServlet defaultServlet = new DefaultServlet();
        Context context = new Context();
    }
}

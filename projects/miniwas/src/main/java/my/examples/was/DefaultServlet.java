package my.examples.was;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class DefaultServlet {
    private BufferedReader request = null;
    private PrintWriter response = null;

    public DefaultServlet() {

    }

    public DefaultServlet(BufferedReader request, PrintWriter response) {
        this.request = request;
        this.response = response;
    }

}

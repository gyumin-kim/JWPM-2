package my.examples.web.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {

    public LifecycleServlet() {
        System.out.println("LifecycleServlet 생성!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init 호출!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy 호출!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service 호출!");
    }
}

package my.examples.was;

import java.io.PrintWriter;

@WebServlet("/my")
public class MyServlet extends HttpServlet {
    @Override
    public void doGet(Request request, Response response) {
        System.out.println("doGet() 실행!");
        PrintWriter out = response.getPw();
        for(int i = 0; i < 10; i++)
            out.println("<h1>hello</h1>");
    }
}

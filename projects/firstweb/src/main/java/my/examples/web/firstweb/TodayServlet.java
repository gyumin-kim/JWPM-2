package my.examples.web.firstweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;

// http://localhost:8080/{context path}/today로 요청하면 이 Servlet class가 실행됨
@WebServlet("/today")
public class TodayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        LocalDateTime today = LocalDateTime.now();
        out.println("today: " + today.toString());
        out.close();
    }
}
package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook/list")
public class GuestbookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB에서 목록을 읽어온다.
        GuestbookDao guestbookDao = new GuestbookDao();
        List<Guestbook> list = guestbookDao.getGuestbookList();

        // request scope - request에 값을 저장하여 JSP까지 값을 전달
        // 읽어온 결과를 JSP에게 전달하기 위해 request에 값을 저장한다.
        req.setAttribute("guestbookList", list);
        req.setAttribute("guestbookSize", list.size());

        // JSP에 forwarding한다. forwarding은 URL이 변경되지 않고 JSP에게 값을 전달.
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        dispatcher.forward(req, resp);
    }
}

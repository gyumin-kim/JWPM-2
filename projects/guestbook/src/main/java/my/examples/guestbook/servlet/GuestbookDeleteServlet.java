package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/guestbook/delete")
public class GuestbookDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // id를 읽어들인다. (query parameter. ex) ?id=100)
        String id = req.getParameter("id");
        System.out.println(id);

        // 세션에서 관리자 로그인 정보가 있는지 확인한다.
        HttpSession session = req.getSession();
        String admin = (String) session.getAttribute("admin");

        // id에 해당하는 방명록을 삭제한다.
        if (admin != null && admin.equals("true")) {
            System.out.println(id + "번 게시글 삭제");
            GuestbookDao guestbookDao = new GuestbookDao();
            guestbookDao.deleteGuestbook(Long.parseLong(id));
        }

        resp.sendRedirect("/guestbook/list");
    }
}

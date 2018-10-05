package my.examples.guestbook.servlet;

import my.examples.guestbook.dao.GuestbookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/guestbook/write")
public class GuestbookWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 이름과 내용을 읽어들인다
        String name = req.getParameter("name");
        String content = req.getParameter("content");
        System.out.print("작성자: " + name + " / ");
        System.out.println("내용: " + content);

        // 이름과 내용을 검사한다
        // DB에 삽입한다
        GuestbookDao guestbookDao = new GuestbookDao();
        Guestbook guestbook = new Guestbook(name, content);
        guestbookDao.addGuestbook(guestbook);

        // /guestbook/list로 redirect
        resp.sendRedirect("/guestbook/list");
    }
}

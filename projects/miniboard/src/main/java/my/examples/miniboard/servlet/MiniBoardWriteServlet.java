package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 글 작성 페이지에서 POST 방식으로 form 전송 시, 요청 처리하는 메소드
 */
@WebServlet("/miniboard/write")
public class MiniBoardWriteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 이름과 내용을 읽어들인다
        String userName = req.getParameter("username");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        System.out.print("작성자: " + title + " / ");
        System.out.print("제목: " + title + " / ");
        System.out.println("내용: " + content);

        // 이름과 내용을 검사한다
        // DB에 삽입한다
        ArticleDao articleDao = new ArticleDao();
//        Article article = new Article(title, content);
//        articleDao.addArticle(article);

        // /guestbook/list로 redirect
        resp.sendRedirect("/miniboard/list");
    }
}
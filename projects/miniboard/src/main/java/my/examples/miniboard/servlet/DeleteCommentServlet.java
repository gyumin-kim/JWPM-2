package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dao.CommentDao;
import my.examples.miniboard.dto.Article;
import my.examples.miniboard.dto.Comment;
import my.examples.miniboard.dto.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/miniboard/delete")
public class DeleteCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("authUser");
        Long commentId = Long.parseLong(req.getParameter("comment1"));
        Long articleId = Long.parseLong(req.getParameter("article1"));

        //;ArticleDao articleDao = new ArticleDao();
        try {
            //Article article = articleDao.getArticle(articleId);

            //댓글 삭제
            CommentDao commentDao = new CommentDao();
            boolean result = commentDao.deleteComment(commentId);

            if (result) {
                resp.sendRedirect("/miniboard/detail?id=" + articleId);
            }

        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
    }
}
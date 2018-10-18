package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dao.CommentDao;
import my.examples.miniboard.dto.Article;
import my.examples.miniboard.dto.Comment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/miniboard/detail")
public class ArticleDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long articleId = Long.parseLong(req.getParameter("id"));
        ArticleDao articleDao = new ArticleDao();
        try {
            Article article = articleDao.getArticle(articleId);
            req.setAttribute("article", article);

            // 해당 article의 id에 해당하는 comment들을 불러온다.
            CommentDao commentDao = new CommentDao();
            List<Comment> commentList = commentDao.getCommentList(articleId);
            req.setAttribute("commentList", commentList);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/articleDetail.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long articleId = Long.parseLong(req.getParameter("articleId"));
        Long userId = Long.parseLong(req.getParameter("userId"));
        String content = req.getParameter("content");

        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setUserId(userId);
        comment.setContent(content);

        // 댓글 등록
        CommentDao commentDao = new CommentDao();
        commentDao.addComment(comment);

        resp.sendRedirect("/miniboard/detail?id=" + articleId);
    }
}

package my.examples.miniboard.servlet;

import my.examples.miniboard.dao.ArticleDao;
import my.examples.miniboard.dto.Article;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/miniboard/list")
public class ListServlet extends HttpServlet {
// ListServlet에서는 전체 글을 다 보여준다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleDao articleDao = new ArticleDao();

        String country = req.getParameter("country");
        String category = req.getParameter("category");
        System.out.println("나라선택" + country);

        try {
            List<Article> articles = articleDao.getArticleList(country, category);
            req.setAttribute("articleList", articles);
            req.setAttribute("articleListSize", articles.size());
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}

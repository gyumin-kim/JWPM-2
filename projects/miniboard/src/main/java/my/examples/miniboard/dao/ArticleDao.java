package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.servlet.Article;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/fcdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String dbUser = "fcuser";
    private static final String dbPassword = "fc123";

    public List<Article> getArticleList() {
        List<Article> articleList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article ORDER BY id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // rs(결과값)가 없을 때까지 반복
            // DB에서 받은 값을 각 Article 객체에 set하고 list에 add한다.
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getLong(1));
                article.setUserId(rs.getString(2));
                article.setCountry(rs.getString(3));
                article.setCategory(rs.getString(4));
                article.setTitle(rs.getString(5));
                article.setContent(rs.getString(6));
                Date sqlDate = rs.getDate(7);

                java.util.Date date = new java.util.Date(sqlDate.getTime());
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                article.setRegDate(ldt);

                articleList.add(article);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return articleList;
    }

    public int addArticle(Article article) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConfig.connect(dbUrl, dbUser, dbPassword);
            String sql = "INSERT INTO article(id, user_id, country, category, title, content, reg_date) VALUES (null, ?, ?, ?, ?, ? now())";
            ps = conn.prepareStatement(sql);
            ps.setString(1, article.getUserId());
            ps.setString(2, article.getCountry());
            ps.setString(3, article.getCategory());
            ps.setString(4, article.getTitle());
            ps.setString(5, article.getContent());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConfig.close(conn, ps);
        }

        return count;
    }

//    public int deleteArticle(Long id) {
//        int count = 0;
//        Connection conn = null;
//        PreparedStatement ps = null;
//
//        try {
//            conn = DbUtil.connect(dbUrl, dbUser, dbPassword);
//            String sql = "DELETE FROM article WHERE id = ?";
//            ps = conn.prepareStatement(sql);
//            ps.setLong(1, id);
//            count = ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DbUtil.close(conn, ps);
//        }
//
//        return count;
//    }
}

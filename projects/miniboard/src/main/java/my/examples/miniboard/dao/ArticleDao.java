package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.dto.Article;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    public List<Article> getArticleList(String country, String category) {
        List<Article> articleList = new ArrayList<>();

        


        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql;

            if (country == null){
                sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article  ORDER BY id desc";

            } else if (country.equals("korean")){
                if (category == null)  sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'korean' ORDER BY id desc";
                else if (category.equals("promotion"))
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'korean' and category = 'promotion' ORDER BY id desc";
                else
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'korean' and category = 'review' ORDER BY id desc";

            } else if (country.equals("chinese")){
                if (category == null)  sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'chinenes' ORDER BY id desc";
                else if (category.equals("promotion"))
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'chinese' and category = 'promotion' ORDER BY id desc";
                else
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'chinese' and category = 'review' ORDER BY id desc";

            } else if (country.equals("western")){
                if (category == null)  sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'western'ORDER BY id desc";
                else if (category.equals("promotion"))
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'western' and category = 'promotion' ORDER BY id desc";
                else
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'western' and category = 'review' ORDER BY id desc";

            } else {
                if (category == null)  sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'japanese' ORDER BY id desc";
                else if (category.equals("promotion"))
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'japanese' and category = 'promotion' ORDER BY id desc";
                else
                    sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE country = 'japanese' and category = 'review' ORDER BY id desc";

            }

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // rs(결과값)가 없을 때까지 반복
            // DB에서 받은 값을 각 Article 객체에 set하고 list에 add한다.
            while (rs.next()) {
                Article article = new Article();
                article.setId(rs.getLong(1));
                article.setUserId(rs.getLong(2));
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
            throw new RuntimeException(ex);
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
            conn = DBConfig.connect();
            String sql = "INSERT INTO article(id, user_id, country, category, title, content, reg_date) " +
                    "VALUES (null, ?, ?, ?, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, article.getUserId());
            ps.setString(2, article.getCountry());
            ps.setString(3, article.getCategory());
            ps.setString(4, article.getTitle());
            ps.setString(5, article.getContent());
            count = ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps);
        }

        return count;
    }

    public Article getArticle(Long articleId) {
        Article article = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql = "SELECT id, user_id, country, category, title, content, reg_date FROM article WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, articleId);
            rs = ps.executeQuery();

            while (rs.next()) {
                article = new Article();
                article.setId(rs.getLong(1));
                article.setUserId(rs.getLong(2));
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

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return article;
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
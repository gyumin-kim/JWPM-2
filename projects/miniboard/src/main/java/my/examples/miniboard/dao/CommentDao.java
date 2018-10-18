package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.dto.Comment;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CommentDao {
    public List<Comment> getCommentList(Long articleId) {
        List<Comment> commentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql = "SELECT id, article_id, user_id, content, reg_date FROM comment WHERE article_id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, articleId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Comment comment = new Comment();

                comment.setId(rs.getLong(1));
                comment.setArticleId(rs.getLong(2));
                comment.setUserId(rs.getLong(3));
                comment.setContent(rs.getString(4));
                Date sqlDate = rs.getDate(5);
                java.util.Date date = new java.util.Date(sqlDate.getTime());
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                comment.setRegDate(ldt);

                commentList.add(comment);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return commentList;
    }

    public int addComment(Comment comment) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBConfig.connect();
            String sql = "INSERT INTO comment(id, article_id, user_id, content, reg_date) " +
                    "VALUES (null, ?, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, comment.getArticleId());
            ps.setLong(2, comment.getUserId());
            ps.setString(3, comment.getContent());
            count = ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps);
        }

        return count;
    }

    public boolean deleteComment(Long commentId){
        boolean result = false;
        Connection conn = null;
        PreparedStatement ps = null;

        try{
            conn = DBConfig.connect();
            String sql = "DELETE FROM comment WHERE id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, commentId);

            int a = ps.executeUpdate();
            if(a > 0) result = true;
            else result = false;

        } catch (Exception ex){
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps);
        }
        return result;
    }
}

package my.examples.guestbook.dao;

import my.examples.guestbook.servlet.Guestbook;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class GuestbookDao {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/fcdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String dbUser = "fcuser";
    private static final String dbPassword = "fc123";

    public List<Guestbook> getGuestbookList() {
        List<Guestbook> guestbookList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DbUtil.connect(dbUrl, dbUser, dbPassword);
            String sql = "SELECT id, name, content, regdate FROM guestbook ORDER BY id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // rs(결과값)가 없을 때까지 반복
            // DB에서 받은 값을 각 Guestbook 객체에 set하고 list에 add한다.
            while (rs.next()) {
                Guestbook guestbook = new Guestbook();
                guestbook.setId(rs.getLong(1));
                guestbook.setName(rs.getString(2));
                guestbook.setContent(rs.getString(3));
                Date sqlDate = rs.getDate(4);
                java.util.Date date = new java.util.Date(sqlDate.getTime());
                LocalDateTime ldt = date.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                guestbook.setRegdate(ldt);

                guestbookList.add(guestbook);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }

        return guestbookList;
    }

    public int addGuestbook(Guestbook guestbook) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.connect(dbUrl, dbUser, dbPassword);
            String sql = "INSERT INTO guestbook(id, name, content, regdate) VALUES (null, ?, ?, now())";
            ps = conn.prepareStatement(sql);
            ps.setString(1, guestbook.getName());
            ps.setString(2, guestbook.getContent());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps);
        }

        return count;
    }

    public int deleteGuestbook(Long id) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DbUtil.connect(dbUrl, dbUser, dbPassword);
            String sql = "DELETE FROM guestbook WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps);
        }

        return count;
    }
}

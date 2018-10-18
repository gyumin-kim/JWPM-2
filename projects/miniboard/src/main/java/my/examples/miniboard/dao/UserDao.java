package my.examples.miniboard.dao;

import my.examples.miniboard.config.DBConfig;
import my.examples.miniboard.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql = "SELECT id, name, password FROM user ORDER BY id";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // rs(결과값)가 없을 때까지 반복
            // DB에서 받은 값을 각 User 객체에 set하고 list에 add한다.
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));

                userList.add(user);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return userList;
    }

    public int addUser(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try{
            conn = DBConfig.connect();
            String sql = "insert into user (id, name, password) VALUES (null, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            count = ps.executeUpdate();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally {
            DBConfig.close(conn, ps);
        }

        return count;
    }

    public User getUser(String name) {
        User user = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql = "SELECT id, name, password FROM user WHERE name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getLong(1));
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return user;
    }
}
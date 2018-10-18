package studentbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class DBConfig {
    public static Connection connect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studentbookConfig.xml");
        StudentDAO studentDAO = applicationContext.getBean("studentDAO", StudentDAO.class);
        Connection conn = null;

        String jdbcDriver = studentDAO.getJdbcDriver();
        String dbUrl = studentDAO.getDbUrl();
        String dbUser = studentDAO.getDbUser();
        String dbPassword = studentDAO.getDbPassword();

        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {}
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {}
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {}
        }
    }
}

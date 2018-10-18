package my.examples.miniboard.config;

import java.sql.*;

public class DBConfig {
    public static Connection connect() {
        DBProperties dbProperties = DBProperties.getInstance();
        Connection conn = null;

        String jdbcDriver = dbProperties.getJdbcDriver();
        String dbUrl = dbProperties.getDbUrl();
        String dbUser = dbProperties.getDbUser();
        String dbPassword = dbProperties.getDbPassword();
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
        close(conn, ps);
    }
}

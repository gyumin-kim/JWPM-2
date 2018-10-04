package my.examples.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCExam01 {
    public static void main(String[] args) throws Exception {
        // Connection과 관련된 interface를 선언
        Connection conn = null;

        // SQL을 실행하기 위한 interface를 선언
        PreparedStatement ps = null;

        // 결과를 읽어오기 위한 interface를 선언
        ResultSet rs = null;

        try {
            // 1. Driver 등록
            Class.forName("org.h2.Driver");

            String sql = "SELECT role_id, description FROM role WHERE role_id = ?";

            // 2. DB에 연결
            // url은 DBMS마다 형식이 다르다.
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1",
                    "sa", "");

            ps = conn.prepareStatement(sql);
            ps.setInt(1, 100);  // 바인딩한다 (? 부분을 알려준다)

            // executeQuery(): select문 실행, executeUpdate(): insert, update, delete
            rs = ps.executeQuery();

            while (rs.next()) {
                int roleId = rs.getInt(1);
                String description = rs.getString(2);
                System.out.println(roleId + ", "+ description);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // ResultSet, PreparedStatement, Connection은 반드시 finally 블록 안에서 close() 한다.
            try {
                rs.close();
            } catch (Exception ex) {}
            try {
                ps.close();
            } catch (Exception ex) {}
            try {
                conn.close();
            } catch (Exception ex) {}
        }
    }
}

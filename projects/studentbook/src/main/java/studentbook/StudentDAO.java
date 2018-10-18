package studentbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private String jdbcDriver;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public int add(Student student) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            conn = DBConfig.connect();
            String sql = "INSERT INTO student(id, name, korean, english, math) VALUES (null, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getKorean());
            ps.setInt(3, student.getEnglish());
            ps.setInt(4, student.getMath());
            count = ps.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps);
        }

        return count;
    }

    public List<Student> getList() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studentbookConfig.xml");
        List<Student> studentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConfig.connect();
            String sql = "SELECT id, name, korean, english, math FROM student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = applicationContext.getBean("student", Student.class);
                student.setId(rs.getLong(1));
                student.setName(rs.getString(2));
                student.setKorean(rs.getInt(3));
                student.setEnglish(rs.getInt(4));
                student.setMath(rs.getInt(5));

                studentList.add(student);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            DBConfig.close(conn, ps, rs);
        }

        return studentList;
    }
}

package studentbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public MainController mainController() {
        return new MainController(ui(), studentDAO());
    }

    @Bean
    public UI ui() {
        return new UI();
    }

    @Bean
    public StudentDAO studentDAO() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        studentDAO.setDbUrl("jdbc:mysql://localhost:3306/fcdb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
        studentDAO.setDbUser("fcuser");
        studentDAO.setDbPassword("fc123");

        return studentDAO;
    }
}

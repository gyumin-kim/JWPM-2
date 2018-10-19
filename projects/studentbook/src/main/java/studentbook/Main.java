package studentbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("studentbookConfig.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        MainController mainController = applicationContext.getBean("mainController", MainController.class);
        mainController.control();
    }
}

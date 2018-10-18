package dicegame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("exam01.xml");
        Game game = applicationContext.getBean("game", Game.class);
        game.play();
    }
}

package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BoardServiceGetBoardsTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BoardService boardService = context.getBean(BoardService.class);

        List<Board> boardList = boardService.getBoards(2, 5);

        for (Board board : boardList) {
            System.out.println(board);
        }
    }
}

package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dao.BoardDao;
import examples.daoexam.dto.Board;
import examples.daoexam.service.BoardService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class BoardServiceInsertTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		BoardService boardService = ac.getBean(BoardService.class);

		Board board = new Board();
		board.setContent("hello content 2");
		board.setName("lee");
		board.setReadCount(0);
		board.setRegdate(new Date()); // java.util.Date
		board.setTitle("title 2");

		Board result = boardService.addBoard(board);
		System.out.println(result);
	}

}

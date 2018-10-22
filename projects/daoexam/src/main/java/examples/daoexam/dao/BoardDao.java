package examples.daoexam.dao;

import examples.daoexam.dto.Board;
import examples.daoexam.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class BoardDao {
    private NamedParameterJdbcTemplate jdbc;
    // insert
    private SimpleJdbcInsert insertAction;

    public BoardDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("board")
                .usingGeneratedKeyColumns("id");
    }

    public Long addBoard(Board board) {
        // Board DTO의 내용을 읽어들여서 Insert 문장에 바인딩할 값을 가지고 있는
        // SqlParameterSouce객체를 생성.
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);

        //id가 자동으로 증가하지 않을 경우에는 다음과 같이 execute()메소드를 사용한다.
        //insertAction.execute(Map) or insertAction.execute(SqlParameterSource)
        //insert가 실행되고, 자동으로 증가한 id값을 리턴한다.
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int updateCount(Long id) {
        String sql = "UPDATE board SET read_count = read_count + 1 WHERE id = :id";
        Map<String, Long> map = Collections.singletonMap("id", id);
        return jdbc.update(sql, map);
    }

    public int deleteBoard(Long id) {
        String sql = "DELETE FROM board WHERE id = :id";
        Map<String, Long> map = Collections.singletonMap("id", id);
//        Map<String, Long> map = new HashMap<>();
//        map.put("id", 1L);
        return jdbc.update(sql, map);
    }

    public int updateBoard(Board board) {
        String sql = "UPDATE board SET name = :name, title = :title, content = :content " +
                    "WHERE id = :id";
//        Map<String, Object> map = new HashMap<>();
//        map.put("id", board.getId());
//        map.put("name", board.getName());
//        map.put("title", board.getTitle());
//        map.put("content", board.getContent());
        SqlParameterSource params = new BeanPropertySqlParameterSource(board);
        return jdbc.update(sql, params);
    }

    public Board getBoard(Long id){
        String sql = "SELECT id, name, title, content, regdate, read_count " +
                    "FROM board WHERE id = :id";
        try {
            // Board에 값을 담아주는 규칙을 가지고 있는 RowMapper를 만든다.
            // Board.class정보를 읽어들여서 프로퍼티의 이름을 가지고 칼럼에 담아주는 규칙을 만든다.
            // readCount라는 프로퍼티가 있으면 read_count라는 칼럼의 값을 담아준다.
            RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
            Map<String, ?> paramMap = Collections.singletonMap("id", id);
            // 한건 or null 을 조회할 때는 queryForObject
            // 첫번째 파라미터 : sql
            // 두번째 파라미터 : 바인딩할 Map
            // 세번째 파라미터 : Mapper (칼럼을 DTO에 담아주기 위한 규칙)
            return jdbc.queryForObject(sql, paramMap, rowMapper);
        } catch (Exception ex) {
            return null;
        }
    }

    // board에서 id가 start인 것부터 limit개 만큼 가져온다
    public List<Board> getBoards(int start, int limit) {
        String sql = "SELECT * FROM board WHERE id >= :start LIMIT :limit";
        RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("start", start);
        paramMap.put("limit", limit);

        return jdbc.query(sql, paramMap, rowMapper);
    }
}
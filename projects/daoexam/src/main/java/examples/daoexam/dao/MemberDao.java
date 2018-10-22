package examples.daoexam.dao;

import examples.daoexam.dto.Member;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class MemberDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert simpleJdbcInsert;

    public MemberDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member")
                .usingGeneratedKeyColumns("id");
    }

    public Long addMember(Member member) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(member);
        return simpleJdbcInsert.executeAndReturnKey(params).longValue();
    }

    public Member getMember(String email) {
        String sql = "SELECT id, name, email, password, reg_date FROM member WHERE email = :email";

        try {
            RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
            Map<String, ?> params = Collections.singletonMap("email", email);
            return jdbc.queryForObject(sql, params, rowMapper);
        } catch (Exception ex) {
            return null;
        }
    }
}

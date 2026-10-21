package _3660721_nguyentranquocviet_tuan6_jdbctemplate.repository;

import _3660721_nguyentranquocviet_tuan6_jdbctemplate.model.Position;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionRepository {

    private final JdbcTemplate jdbc;

    private static final RowMapper<Position> MAPPER = (rs, rowNum) ->
            new Position(rs.getInt("id"), rs.getString("title"));

    public PositionRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Position> findAll() {
        return jdbc.query("SELECT id, title FROM positions ORDER BY id", MAPPER);
    }
}

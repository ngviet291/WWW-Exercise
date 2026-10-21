package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import _3660721_nguyentranquocviet_tuan6_jdbc.model.Position;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionMapper implements ResultSetMapper<Position> {
    @Override
    public Position map(ResultSet rs) throws SQLException {
        return new Position(rs.getInt("id"), rs.getString("title"));
    }
}

package _3660721_nguyentranquocviet_tuan6_jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {
    T map(ResultSet rs) throws SQLException;
}

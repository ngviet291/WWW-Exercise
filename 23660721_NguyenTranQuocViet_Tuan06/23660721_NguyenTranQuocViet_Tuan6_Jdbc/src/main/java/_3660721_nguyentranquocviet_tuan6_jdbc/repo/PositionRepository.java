package _3660721_nguyentranquocviet_tuan6_jdbc.repo;

import _3660721_nguyentranquocviet_tuan6_jdbc.utils.DBConnection;
import _3660721_nguyentranquocviet_tuan6_jdbc.mapper.PositionMapper;
import _3660721_nguyentranquocviet_tuan6_jdbc.model.Position;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PositionRepository {

    private final DBConnection db;
    private final PositionMapper mapper = new PositionMapper();

    public PositionRepository(DBConnection db) {
        this.db = db;
    }

    public List<Position> findAll() {
        List<Position> result = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT id, title FROM positions ORDER BY id");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                result.add(mapper.map(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}

package _3660721_nguyentranquocviet_tuan6_jdbc.repo;

import _3660721_nguyentranquocviet_tuan6_jdbc.utils.DBConnection;
import _3660721_nguyentranquocviet_tuan6_jdbc.mapper.DepartmentMapper;
import _3660721_nguyentranquocviet_tuan6_jdbc.model.Department;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

    private final DBConnection db;
    private final DepartmentMapper mapper = new DepartmentMapper();

    public DepartmentRepository(DBConnection db) {
        this.db = db;
    }

    public List<Department> findAll() {
        return query("SELECT id, name FROM departments ORDER BY id");
    }

    // Department chưa có Employee nào
    public List<Department> findDepartmentsWithoutEmployees() {
        return query("""
                SELECT d.id, d.name
                FROM departments d
                LEFT JOIN employees e ON e.department_id = d.id
                WHERE e.id IS NULL
                ORDER BY d.id
                """);
    }

    private List<Department> query(String sql) {
        List<Department> result = new ArrayList<>();
        try (Connection con = db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
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

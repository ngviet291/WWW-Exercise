package _3660721_nguyentranquocviet_tuan6_mongodb.repo;

import _3660721_nguyentranquocviet_tuan6_mongodb.dto.DepartmentCount;
import _3660721_nguyentranquocviet_tuan6_mongodb.dto.DepartmentSalary;
import _3660721_nguyentranquocviet_tuan6_mongodb.mapper.DepartmentCountMapper;
import _3660721_nguyentranquocviet_tuan6_mongodb.mapper.DepartmentSalaryMapper;
import _3660721_nguyentranquocviet_tuan6_mongodb.mapper.EmployeeMapper;
import _3660721_nguyentranquocviet_tuan6_mongodb.model.Employee;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;


@Repository
public class EmployeeRepository {

    private static final String DEPARTMENTS = "departments";

    private final MongoTemplate mongoTemplate;
    private final EmployeeMapper employeeMapper = new EmployeeMapper();
    private final DepartmentCountMapper countMapper = new DepartmentCountMapper();
    private final DepartmentSalaryMapper salaryMapper = new DepartmentSalaryMapper();

    public EmployeeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private MongoCollection<Document> departments() {
        return mongoTemplate.getCollection(DEPARTMENTS);
    }

    // ---------- CRUD ----------
    public void save(Employee e) {
        if (e.getId() == null) {
            e.setId(nextEmployeeId());
            pushToDepartment(e);
            return;
        }
        Integer oldDepartmentId = findDepartmentIdOf(e.getId());
        if (oldDepartmentId == null) {
            pushToDepartment(e);
        } else if (oldDepartmentId.equals(e.getDepartmentId())) {
            departments().updateOne(
                    Filters.and(Filters.eq("_id", oldDepartmentId), Filters.eq("employees.employeeId", e.getId())),
                    Updates.combine(
                            Updates.set("employees.$.name", e.getName()),
                            Updates.set("employees.$.role", e.getRole()),
                            Updates.set("employees.$.age", e.getAge()),
                            Updates.set("employees.$.salary", e.getSalary()),
                            Updates.set("employees.$.positionId", e.getPositionId())));
        } else {
            departments().updateOne(Filters.eq("_id", oldDepartmentId),
                    Updates.pull("employees", new Document("employeeId", e.getId())));
            pushToDepartment(e);
        }
    }

    public void deleteById(Integer id) {
        departments().updateMany(Filters.exists("employees"),
                Updates.pull("employees", new Document("employeeId", id)));
    }

    public List<Employee> findAll() {
        return queryEmployees(null, Sorts.ascending("employeeId"), null);
    }

    public Optional<Employee> findById(Integer id) {
        List<Employee> result = queryEmployees(Filters.eq("employeeId", id), Sorts.ascending("employeeId"), null);
        return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
    }

    // ---------- Tìm kiếm ----------
    public List<Employee> findByNameContainingIgnoreCase(String name) {
        return queryEmployees(Filters.regex("name", Pattern.quote(name), "i"), Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findByAgeBetween(Integer a, Integer b) {
        return queryEmployees(Filters.and(Filters.gte("age", a), Filters.lte("age", b)),
                Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findBySalaryGreaterThan(Double s) {
        return queryEmployees(Filters.gt("salary", s), Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findByPositionId(Integer positionId) {
        return queryEmployees(Filters.eq("positionId", positionId), Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findByDepartmentId(Integer departmentId) {
        return queryEmployees(Filters.eq("departmentId", departmentId), Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findByDepartmentIdAndPositionId(Integer departmentId, Integer positionId) {
        return queryEmployees(Filters.and(Filters.eq("departmentId", departmentId), Filters.eq("positionId", positionId)),
                Sorts.ascending("employeeId"), null);
    }

    public List<Employee> findTopByDepartmentIdOrderBySalaryDesc(Integer departmentId, int n) {
        return queryEmployees(Filters.eq("departmentId", departmentId), Sorts.descending("salary"), n);
    }

    // ---------- Thống kê ----------
    public List<DepartmentCount> countEmployeesByDepartment() {
        List<Bson> pipeline = List.of(
                Aggregates.sort(Sorts.ascending("_id")),
                Aggregates.project(Projections.fields(
                        Projections.excludeId(),
                        Projections.include("name"),
                        Projections.computed("employeeCount",
                                new Document("$size",
                                        new Document("$ifNull", Arrays.<Object>asList("$employees", Collections.emptyList())))))));
        List<DepartmentCount> result = new ArrayList<>();
        for (Document doc : departments().aggregate(pipeline)) {
            result.add(countMapper.map(doc));
        }
        return result;
    }

    public List<DepartmentSalary> salaryStatsByDepartment() {
        List<Bson> pipeline = List.of(
                Aggregates.unwind("$employees"),
                Aggregates.group("$_id",
                        Accumulators.first("name", "$name"),
                        Accumulators.avg("avgSalary", "$employees.salary"),
                        Accumulators.sum("totalSalary", "$employees.salary")),
                Aggregates.sort(Sorts.ascending("_id")));
        List<DepartmentSalary> result = new ArrayList<>();
        for (Document doc : departments().aggregate(pipeline)) {
            result.add(salaryMapper.map(doc));
        }
        return result;
    }

    private List<Employee> queryEmployees(Bson filter, Bson sort, Integer limit) {
        List<Bson> pipeline = new ArrayList<>();
        pipeline.add(Aggregates.unwind("$employees"));
        pipeline.add(Aggregates.project(Projections.fields(
                Projections.excludeId(),
                Projections.computed("employeeId", "$employees.employeeId"),
                Projections.computed("name", "$employees.name"),
                Projections.computed("role", "$employees.role"),
                Projections.computed("age", "$employees.age"),
                Projections.computed("salary", "$employees.salary"),
                Projections.computed("positionId", "$employees.positionId"),
                Projections.computed("departmentId", "$_id"))));
        if (filter != null) {
            pipeline.add(Aggregates.match(filter));
        }
        pipeline.add(Aggregates.sort(sort));
        if (limit != null) {
            pipeline.add(Aggregates.limit(limit));
        }
        List<Employee> result = new ArrayList<>();
        for (Document doc : departments().aggregate(pipeline)) {
            result.add(employeeMapper.map(doc));
        }
        return result;
    }

    private void pushToDepartment(Employee e) {
        UpdateResult r = departments().updateOne(Filters.eq("_id", e.getDepartmentId()),
                Updates.push("employees", toDocument(e)));
        if (r.getMatchedCount() == 0) {
            throw new IllegalArgumentException("Không tìm thấy phòng ban #" + e.getDepartmentId());
        }
    }

    private Document toDocument(Employee e) {
        return new Document("employeeId", e.getId())
                .append("name", e.getName())
                .append("role", e.getRole())
                .append("age", e.getAge())
                .append("salary", e.getSalary())
                .append("positionId", e.getPositionId());
    }

    private Integer nextEmployeeId() {
        Document d = departments().aggregate(List.of(
                Aggregates.unwind("$employees"),
                Aggregates.group(null, Accumulators.max("maxId", "$employees.employeeId")))).first();
        Number max = d == null ? null : d.get("maxId", Number.class);
        return max == null ? 1 : max.intValue() + 1;
    }

    private Integer findDepartmentIdOf(Integer employeeId) {
        Document d = departments().find(Filters.eq("employees.employeeId", employeeId))
                .projection(Projections.include("_id")).first();
        return d == null ? null : d.get("_id", Number.class).intValue();
    }
}

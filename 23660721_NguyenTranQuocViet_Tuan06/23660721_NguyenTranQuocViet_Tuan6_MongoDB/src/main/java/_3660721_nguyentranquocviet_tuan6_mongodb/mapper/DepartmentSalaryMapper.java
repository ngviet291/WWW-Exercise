package _3660721_nguyentranquocviet_tuan6_mongodb.mapper;

import _3660721_nguyentranquocviet_tuan6_mongodb.dto.DepartmentSalary;
import org.bson.Document;

public class DepartmentSalaryMapper implements DocumentMapper<DepartmentSalary> {

    @Override
    public DepartmentSalary map(Document doc) {
        Double avg = DocumentMapper.toDouble(doc.get("avgSalary", Number.class));
        Double total = DocumentMapper.toDouble(doc.get("totalSalary", Number.class));
        return new DepartmentSalary(
                DocumentMapper.toInteger(doc.get("_id", Number.class)),
                doc.getString("name"),
                avg == null ? 0 : avg,
                total == null ? 0 : total);
    }
}

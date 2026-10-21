package _3660721_nguyentranquocviet_tuan6_mongodb.mapper;

import _3660721_nguyentranquocviet_tuan6_mongodb.dto.DepartmentCount;
import org.bson.Document;

public class DepartmentCountMapper implements DocumentMapper<DepartmentCount> {

    @Override
    public DepartmentCount map(Document doc) {
        Number count = doc.get("employeeCount", Number.class);
        return new DepartmentCount(doc.getString("name"), count == null ? 0 : count.longValue());
    }
}

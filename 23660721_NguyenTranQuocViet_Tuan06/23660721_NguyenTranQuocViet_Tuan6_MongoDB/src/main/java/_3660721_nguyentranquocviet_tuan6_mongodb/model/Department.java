package _3660721_nguyentranquocviet_tuan6_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
public record Department(@Id Integer id, String name) {
}

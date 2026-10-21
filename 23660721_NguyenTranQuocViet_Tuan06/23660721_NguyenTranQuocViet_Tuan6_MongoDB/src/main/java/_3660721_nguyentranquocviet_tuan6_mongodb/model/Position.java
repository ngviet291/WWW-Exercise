package _3660721_nguyentranquocviet_tuan6_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("positions")
public record Position(@Id Integer id, String title) {
}

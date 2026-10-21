package _3660721_nguyentranquocviet_tuan6_mongodb.mapper;

import org.bson.Document;

@FunctionalInterface
public interface DocumentMapper<T> {
    T map(Document doc);

    static Integer toInteger(Number n) { return n == null ? null : n.intValue(); }

    static Double toDouble(Number n) { return n == null ? null : n.doubleValue(); }
}

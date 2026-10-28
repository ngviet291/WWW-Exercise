package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.repository;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.BookQuantityOfPublisher;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherAvg;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Publisher;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PublisherRepository extends ListCrudRepository<Publisher,Integer> {
    @Query("SELECT  p.`name`,COALESCE(COUNT(b.id),0) AS quantity FROM books b RIGHT JOIN publishers p ON p.id = b.publisher_id GROUP BY p.id, p.`name`")
    List<BookQuantityOfPublisher> countBookOfPublishers();
    @Query("SELECT  p.`name`,COALESCE(COUNT(b.id),0) AS quantity FROM books b RIGHT JOIN publishers p ON p.id = b.publisher_id GROUP BY p.id, p.`name` having count(b.id)>=2")
    List<BookQuantityOfPublisher> countMin2BookOfPublishers();
    @Query("SELECT  p.`name`,COALESCE(Avg(b.price),0) AS avg_price FROM books b RIGHT JOIN publishers p ON p.id = b.publisher_id GROUP BY p.id, p.`name`")
    List<PublisherAvg> avgPrice();
}

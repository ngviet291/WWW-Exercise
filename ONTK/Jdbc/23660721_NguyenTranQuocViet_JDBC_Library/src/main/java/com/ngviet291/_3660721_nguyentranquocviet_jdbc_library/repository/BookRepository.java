package com.ngviet291._3660721_nguyentranquocviet_jdbc_library.repository;

import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.dto.PublisherBook;
import com.ngviet291._3660721_nguyentranquocviet_jdbc_library.model.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends ListCrudRepository<Book,Integer> {
    List<Book> findByPublisherIdAndAuthorContainingIgnoreCase(Integer publisherId, String author);
    @Query("SELECT b.id, b.title, p.`name` as publisher_name FROM books b LEFT JOIN publishers p ON p.id= b.publisher_id WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<PublisherBook> findByPublisherName(@Param("name") String name);
}

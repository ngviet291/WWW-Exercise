package com.ngviet291._3660721_nguyentranquocviet_jpa_library.repository;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByPublisherIdAndAuthorContainingIgnoreCase(Integer publisherId, String author);
}

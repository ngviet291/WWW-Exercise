package com.ngviet291._3660721_nguyentranquocviet_jpa_library.repository;

import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Book;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.model.Publisher;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAuthorResponse;
import com.ngviet291._3660721_nguyentranquocviet_jpa_library.projection.PublisherAvg;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher,Integer> {
    @Query("SELECT p.name as name, AVG(b.price) AS avgPrice FROM Book b right JOIN b.publisher p  GROUP BY p.id,p.name")
    List<PublisherAvg> getAvgPrice();
}

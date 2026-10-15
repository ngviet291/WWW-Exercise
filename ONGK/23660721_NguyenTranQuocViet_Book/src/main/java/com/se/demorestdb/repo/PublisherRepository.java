package com.se.demorestdb.repo;

import com.se.demorestdb.dto.BooksOfPublisher;
import com.se.demorestdb.dto.Statics;
import com.se.demorestdb.model.Book;
import com.se.demorestdb.model.Publisher;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PublisherRepository {
    @Inject
    private DataSource dataSource;
    public List<Publisher> getPublishers(){
        List<Publisher> publishers = new ArrayList<>();
        String sql = "Select * from publishers";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
        ){
            while (rs.next()){
                Publisher publisher=Publisher.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .address(rs.getString(3))
                        .build();
                publishers.add(publisher);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publishers;
    }
    public Publisher getPublisher(int id){
        String sql = "Select * from publishers WHERE publishers.id=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);

        ){
            ps.setInt(1,id);
            try (ResultSet rs = ps.executeQuery();){
                while (rs.next()){
                    return Publisher.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .address(rs.getString(3))
                            .build();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Map<Publisher,List<Book>> findByPublisherAndAuthor(int publisherId, String authorKeyword){
        Map<Publisher, List<Book>> result = new LinkedHashMap<>();
        String sql = "SELECT p.id AS publisherId,p.`name`,p.address,b.id AS bookId,b.title,b.author, b.price FROM publishers p INNER JOIN books b ON b.publisher_id=p.id WHERE p.id=? AND b.author LIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps= connection.prepareStatement(sql);
        ){
            ps.setInt(1,publisherId);
            ps.setString(2, "%"+authorKeyword+"%");
            try (ResultSet rs = ps.executeQuery()){
                List<Book> books= null;
                while (rs.next()) {
                    if (books == null) {
                        Publisher publisher = Publisher.builder()
                                .id(rs.getInt("publisherId"))
                                .name(rs.getString("name"))
                                .address(rs.getString("address"))
                                .build();
                        books= new ArrayList<>();
                        result.put(publisher, books);
                    }
                    books.add(Book.builder()
                            .id(rs.getInt("bookId"))
                            .title(rs.getString("title"))
                            .author(rs.getString("author"))
                            .price(rs.getDouble("price"))
                            .build());

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<Statics> getStatistics() {
        List<Statics> list = new ArrayList<>();
        String sql ="SELECT p.id ,p.`name`, COALESCE(count(b.id),0) AS bookCount, COALESCE(SUM(b.price),0) AS totalPrice,COALESCE(AVG(b.price),0) AS avgPrice  FROM publishers p LEFT JOIN books b ON p.id=b.publisher_id GROUP BY p.`name`,p.id";

        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                Statics statics = Statics.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .bookCount(rs.getInt("bookCount"))
                        .totalPrice(rs.getDouble("totalPrice"))
                        .avgPrice(rs.getDouble("avgPrice")).build();
                list.add(statics);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public List<BooksOfPublisher> countBooksByPublisher(){

        List<BooksOfPublisher> booksOfPublishers = new ArrayList<>();
        String sql ="SELECT p.id,p.`name`, COALESCE(COUNT(b.id),0) AS quantity FROM publishers p LEFT JOIN books b ON b.publisher_id=p.id GROUP BY p.id,p.`name`";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ) {
                while (rs.next()){
                    BooksOfPublisher booksOfPublisher= BooksOfPublisher.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .quantity(rs.getInt("quantity")).build();
                    booksOfPublishers.add(booksOfPublisher);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return booksOfPublishers;
    }
}

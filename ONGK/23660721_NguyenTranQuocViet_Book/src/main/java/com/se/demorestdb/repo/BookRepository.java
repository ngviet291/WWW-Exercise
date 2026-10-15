package com.se.demorestdb.repo;

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
public class BookRepository {

    @Inject
    private DataSource dataSource;
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
               Book book = new Book();
               book.setTitle(rs.getString(2));
               book.setAuthor(rs.getString(3));
               book.setPrice(rs.getDouble(4));
               book.setPublisherId(rs.getInt(5));
               book.setId(rs.getInt(1));
               books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }
    public Book findByAuthor(String author){
        String sql ="SELECT * FROM books WHERE books.author = ?";
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ) {
            ps.setString(1,author);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    return Book.builder()
                            .id(rs.getInt(1))
                            .title(rs.getString(2))
                            .author(rs.getString(3))
                            .price(rs.getDouble(4))
                            .build();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }
    public boolean save(Book book){
        String sql = "INSERT INTO books(title, author, price, publisher_id) VALUE(?,?,?,?)";
        try (
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
                ps.setString(1,book.getTitle());
                ps.setString(2,book.getAuthor());
                ps.setDouble(3,book.getPrice());
                ps.setInt(4,book.getPublisherId());
                int affectRow = ps.executeUpdate();
                return affectRow>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
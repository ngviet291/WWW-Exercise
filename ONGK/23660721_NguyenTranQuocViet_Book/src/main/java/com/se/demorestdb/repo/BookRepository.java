package com.se.demorestdb.repo;

import com.se.demorestdb.dto.BookSearchRequest;
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
import java.util.List;
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
    public List<BookSearchRequest> findByPublisherAndAuthor(int publisherId, String authorKeyword){
        List<Book> books = new ArrayList<>();
        List<BookSearchRequest> result = new ArrayList<>();
        Publisher publisher = null;
        String sql = "SELECT p.id AS publisherId,p.`name`,p.address,b.id AS bookId,b.title,b.author, b.price FROM publishers p INNER JOIN books b ON b.publisher_id=p.id WHERE p.id=? AND b.author LIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps= connection.prepareStatement(sql);
        ){
            ps.setInt(1,publisherId);
            ps.setString(2, "%"+authorKeyword+"%");
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    if (publisher == null) {
                        publisher = Publisher.builder()
                                .id(rs.getInt("publisherId"))
                                .name(rs.getString("name"))
                                .address(rs.getString("address"))
                                .build();
                    }
                    books.add(Book.builder()
                            .id(rs.getInt("bookId"))
                            .title(rs.getString("title"))
                            .author(rs.getString("author"))
                            .price(rs.getDouble("price"))
                            .build());

                }
                if(publisher!=null){
                result.add(BookSearchRequest.builder().publisher(publisher).books(books).build());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
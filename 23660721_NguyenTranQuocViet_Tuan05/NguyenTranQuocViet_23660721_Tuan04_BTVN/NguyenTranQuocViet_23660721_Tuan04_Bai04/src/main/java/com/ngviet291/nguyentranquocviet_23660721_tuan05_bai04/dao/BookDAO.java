package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.dao;

import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model.Book;
import com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.util.DBUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private final DBUtil util;

    public BookDAO(DataSource dataSource) {
        util = new DBUtil(dataSource);
    }

    public List<Book> getAllBooks() {
        return getBooks("SELECT * FROM books");
    }

    public Book getBookById(String id) {
        String sql = "SELECT * FROM books WHERE bookId = ?";

        try (Connection conn = util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return getBook(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Book> searchBooks(String keyword) {
        return getBooks(
                "SELECT * FROM books WHERE LOWER(title) LIKE LOWER('%" + keyword + "%')"
        );
    }

    private List<Book> getBooks(String sql) {
        List<Book> books = new ArrayList<>();

        try (Connection conn = util.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                books.add(getBook(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return books;
    }

    private Book getBook(ResultSet rs) throws SQLException {
        return Book.builder()
                .bookId(rs.getString("bookId"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .price(rs.getDouble("price"))
                .quantity(rs.getInt("quantity"))
                .image(rs.getString("image"))
                .build();
    }
}
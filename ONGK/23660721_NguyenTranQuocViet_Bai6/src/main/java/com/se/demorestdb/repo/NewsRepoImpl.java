package com.se.demorestdb.repo;

import com.se.demorestdb.model.Category;
import com.se.demorestdb.model.News;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsRepoImpl {
    private volatile DataSource dataSource;
    private DataSource dataSource(){
        if (dataSource == null) {
            try {
                Context env = (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) env.lookup("jdbc/quanlytintuc");
            } catch (javax.naming.NamingException e) {
                throw new RuntimeException(e);
            }
        }
        return dataSource;
    }
    public List<News> getAllNews() {
        List<News> news = new ArrayList<>();
        String sql = "SELECT * FROM tintuc";
        try (
                Connection con= dataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()) {
                News n = new News();
                n.setId(rs.getInt("MATT"));
                n.setTitle(rs.getString("TIEUDE"));
                n.setContent(rs.getString("NOIDUNGTT"));
                n.setUrl(rs.getString("LIENKET"));
                news.add(n);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }
    public News getNewsById(int id) {
        News news = null;
        String sql = "SELECT * FROM tintuc WHERE MATT = ?";
        try (
                Connection con= dataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    news = new News();
                    news.setId(rs.getInt("MATT"));
                    news.setTitle(rs.getString("TIEUDE"));
                    news.setContent(rs.getString("NOIDUNGTT"));
                    news.setUrl(rs.getString("LIENKET"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return news;
    }
    public boolean addNews(News news) {
        String sql = "INSERT INTO tintuc (TIEUDE, NOIDUNGTT, LIENKET) VALUES (?, ?, ?)";
        try (
                Connection con= dataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContent());
            ps.setString(3, news.getUrl());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public News updateNews(News news) {
        String sql = "UPDATE tintuc SET TIEUDE = ?, NOIDUNGTT = ?, LIENKET = ? WHERE MATT = ?";
        try (
                Connection con= dataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getContent());
            ps.setString(3, news.getUrl());
            ps.setInt(4, news.getId());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return news;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean deleteNews(int id) {
        String sql = "DELETE FROM tintuc WHERE MATT = ?";
        try (
                Connection con= dataSource().getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<News> getAllNewsWithCategory (){
        List<News> newsList=new ArrayList<>();
        String sql ="SELECT t.MATT,t.NOIDUNGTT,d.TENDANHMUC FROM tintuc t INNER JOIN danhmuc d On t.MADM=d.MADM;";
        try (
                Connection connection= dataSource().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs= ps.executeQuery();
                ){
            while(rs.next()){
                News news = new News();
                news.setId(rs.getInt(1));
                news.setContent(rs.getString(2));
                news.setCategory(rs.getString(3));
                newsList.add(news);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newsList;
    }
    public List<News> getNewsWithCategoryName (String categoryName){
        List<News> newsList=new ArrayList<>();
        String sql ="SELECT t.MATT ,t.TIEUDE, t.NOIDUNGTT, d.TENDANHMUC FROM tintuc t INNER JOIN danhmuc d ON t.MADM = d.MADM where d.TENDANHMUC=?";
        try (
                Connection connection= dataSource().getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setString(1,categoryName);
            try(ResultSet rs =ps.executeQuery()){
                while (rs.next()){
                News news = new News();
                news.setId(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setContent(rs.getString(3));
                news.setCategory(rs.getString(4));
                newsList.add(news);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return newsList;
    }
}

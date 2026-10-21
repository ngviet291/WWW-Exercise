package com.se.demorestdb.repo;

import com.se.demorestdb.dto.*;
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
    public BookByPublisherAndAuthorDto findByPublisherAndAuthor(int publisherId, String authorKeyword){
        Publisher publisher = null;
        List<Book> books= new ArrayList<>();
        String sql = "SELECT p.id AS publisherId,p.`name`,p.address,b.id AS bookId,b.title,b.author, b.price FROM publishers p INNER JOIN books b ON b.publisher_id=p.id WHERE p.id=? AND b.author LIKE ?";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps= connection.prepareStatement(sql);
        ){
            ps.setInt(1,publisherId);
            ps.setString(2, "%"+authorKeyword+"%");
            try (ResultSet rs = ps.executeQuery()){

                while (rs.next()) {
                    if(publisher==null){
                         publisher = Publisher.builder()
                                .id(rs.getInt("publisherId"))
                                .name(rs.getString("name"))
                                .address(rs.getString("address"))
                                .build();

                    }

                    books.add(Book.builder()
                            .id(rs.getInt("bookId"))
                            .title(rs.getString("title"))
                            .publisherId(publisherId)
                            .author(rs.getString("author"))
                            .price(rs.getDouble("price"))
                            .build());

                }
            }
            return BookByPublisherAndAuthorDto.builder()
                    .publisher(publisher)
                    .books(books)
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
    public List<PublisherQuantityDto> countBooksByPublisher(){

        List<PublisherQuantityDto> publisherQuantityDtos = new ArrayList<>();
        String sql ="SELECT p.id,p.`name`, COALESCE(COUNT(b.id),0) AS quantity FROM publishers p LEFT JOIN books b ON b.publisher_id=p.id GROUP BY p.id,p.`name`";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ) {
                while (rs.next()){
                    PublisherQuantityDto publisherQuantityDto = PublisherQuantityDto.builder()
                            .id(rs.getInt("id"))
                            .name(rs.getString("name"))
                            .quantity(rs.getInt("quantity")).build();
                    publisherQuantityDtos.add(publisherQuantityDto);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publisherQuantityDtos;
    }
    public List<PublisherQuantityDto> findWithAtLeast(int n){
        String sql = "SELECT p.id, p.`name`, COUNT(b.id)AS quantity FROM publishers p INNER JOIN books b ON b.publisher_id = p.id GROUP BY p.`name`,p.id HAVING COUNT(b.id)>=?";
        List<PublisherQuantityDto> publisherQuantityDtos = new ArrayList<>();
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
        ){
            ps.setInt(1,n);
                try (ResultSet rs= ps.executeQuery()){
                    while (rs.next()){
                        PublisherQuantityDto publisherQuantityDto = PublisherQuantityDto.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .quantity(rs.getInt("quantity"))
                                .build();
                        publisherQuantityDtos.add(publisherQuantityDto);
                    }
                }
                return publisherQuantityDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PublisherAveragePriceDto> avgPriceByPublisher(){
        String sql ="SELECT p.id, p.`name`, AVG(b.price) AS avgPrice FROM publishers p INNER JOIN books b ON b.publisher_id= p.id GROUP BY p.`name`,p.id ";
        List<PublisherAveragePriceDto> publisherAveragePriceDtos = new ArrayList<>();
        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
                while (rs.next()){
                    PublisherAveragePriceDto publisherAveragePriceDto = PublisherAveragePriceDto.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .avgPrice(rs.getDouble(3))
                            .build();
                    publisherAveragePriceDtos.add(publisherAveragePriceDto);
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publisherAveragePriceDtos;
    }
    public List<PublisherSumPriceDto> sumPriceByPublisher(){
        List<PublisherSumPriceDto> publisherSumPriceDtos = new ArrayList<>();
        String sql ="SELECT p.id, p.`name`, Sum(b.price) AS sumPrice FROM publishers p INNER JOIN books b ON b.publisher_id= p.id GROUP BY p.`name`,p.id;";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                ){
            while (rs.next()){
                PublisherSumPriceDto publisherSumPriceDto = PublisherSumPriceDto.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .totalPrice(rs.getDouble(3))
                        .build();
                publisherSumPriceDtos.add(publisherSumPriceDto);
            }
            return publisherSumPriceDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PublisherSumPriceDto> findWithTotalAbove(Double x){
        List<PublisherSumPriceDto> publisherSumPriceDtos = new ArrayList<>();
        String sql ="SELECT p.id, p.`name`, Sum(b.price) AS sumPrice FROM publishers p INNER JOIN books b ON b.publisher_id= p.id GROUP BY p.`name`,p.id having sumPrice>?;";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);

        ){
            ps.setDouble(1, x);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    PublisherSumPriceDto publisherSumPriceDto = PublisherSumPriceDto.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .totalPrice(rs.getDouble(3))
                            .build();
                    publisherSumPriceDtos.add(publisherSumPriceDto);
                }
            }
            return publisherSumPriceDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PublisherQuantityDto> findWithAtLeastSortedDesc(int n){
        List<PublisherQuantityDto> publisherQuantityDtos = new ArrayList<>();
        String sql ="SELECT p.id, p.`name`, COUNT(b.id)AS quantity FROM publishers p INNER JOIN books b ON b.publisher_id = p.id GROUP BY p.`name`,p.id HAVING quantity>= ? ORDER BY quantity Desc";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);

        ){
            ps.setDouble(1, n);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    PublisherQuantityDto publisherQuantityDto = PublisherQuantityDto.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .build();
                    publisherQuantityDtos.add(publisherQuantityDto);
                }
            }
            return publisherQuantityDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PublisherQuantityDto> findWithoutBooks(){
        List<PublisherQuantityDto> publisherQuantityDtos = new ArrayList<>();
        String sql ="SELECT p.id, p.`name`, COUNT(b.id)AS quantity FROM publishers p LEFT JOIN books b ON b.publisher_id = p.id GROUP BY p.`name`,p.id HAVING quantity=0";
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()

        ){
                while (rs.next()){
                    PublisherQuantityDto publisherQuantityDto = PublisherQuantityDto.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .quantity(rs.getInt(3))
                            .build();
                    publisherQuantityDtos.add(publisherQuantityDto);
                }
            return publisherQuantityDtos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

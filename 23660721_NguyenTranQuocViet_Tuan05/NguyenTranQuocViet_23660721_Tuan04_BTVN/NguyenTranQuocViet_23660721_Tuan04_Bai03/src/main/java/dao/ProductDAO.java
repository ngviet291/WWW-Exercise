package dao;


import model.Product;
import util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        dbUtil = new DBUtil(dataSource);
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (
                Connection connection = dbUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                list.add(
                        Product.builder()
                                .id(resultSet.getInt("ID"))
                                .model(resultSet.getString("MODEL"))
                                .price(resultSet.getDouble("PRICE"))
                                .quantity(resultSet.getInt("QUANTITY"))
                                .description(resultSet.getString("DESCRIPTION"))
                                .imgUrl(resultSet.getString("IMGURL"))
                                .build()
                );
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(int id) {
        String query = "SELECT * FROM products WHERE ID = ?";
        try (
                Connection connection = dbUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Product.builder()
                            .id(resultSet.getInt("ID"))
                            .model(resultSet.getString("MODEL"))
                            .price(resultSet.getDouble("PRICE"))
                            .quantity(resultSet.getInt("QUANTITY"))
                            .description(resultSet.getString("DESCRIPTION"))
                            .imgUrl(resultSet.getString("IMGURL"))
                            .build();
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
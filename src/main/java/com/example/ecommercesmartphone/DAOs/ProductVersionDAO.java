package com.example.ecommercesmartphone.DAOs;

import com.example.ecommercesmartphone.connects.ConnectToSQLServer;
import com.example.ecommercesmartphone.models.ProductVersion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductVersionDAO {

    private static ProductVersionDAO _instance;

    public static ProductVersionDAO getInstance() {
        if (_instance == null) {
            _instance = new ProductVersionDAO();
        }
        return _instance;
    }

    public ProductVersion getById(int id) {
        ProductVersion productVersion = new ProductVersion();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectToSQLServer.getConnection();
            String query = "SELECT pbs.maphienbansp AS id, sp.tensp AS name, pbs.gianhap AS price, sp.kichthuocman AS sizeScreen, dlram.kichthuocram AS ram, dr.kichthuocrom AS rom, sp.hinhanh AS screen, sp.hinhanh AS photo, pbs.soluongton AS quantity " +
                    "FROM sanpham sp " +
                    "INNER JOIN phienbansanpham pbs ON sp.masp = pbs.masp AND pbs.soluongton > 0 AND pbs.trangthai = 1 AND pbs.maphienbansp = ?" +
                    "INNER JOIN dungluongrom dr ON pbs.rom = dr.madlrom " +
                    "INNER JOIN dungluongram dlram ON pbs.ram = dlram.madlram";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                productVersion.setId(resultSet.getInt("id"));
                productVersion.setName(resultSet.getString("name"));
                productVersion.setPrice(resultSet.getDouble("price"));
                productVersion.setSizeScreen(resultSet.getInt("sizeScreen"));
                productVersion.setRam(resultSet.getInt("ram"));
                productVersion.setRom(resultSet.getInt("rom"));
                productVersion.setPhoto(resultSet.getString("photo"));
                productVersion.setQuantity(resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productVersion;
    }

    public List<ProductVersion> getAllProducts() {
        List<ProductVersion> productVersionList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectToSQLServer.getConnection();
            String query = "SELECT pbs.maphienbansp AS id, sp.tensp AS name, pbs.gianhap AS price, sp.kichthuocman AS sizeScreen, dlram.kichthuocram AS ram, dr.kichthuocrom AS rom, sp.hinhanh AS screen, sp.hinhanh AS photo, pbs.soluongton AS quantity " +
                    "FROM sanpham sp " +
                    "INNER JOIN phienbansanpham pbs ON sp.masp = pbs.masp AND pbs.soluongton > 0 AND pbs.trangthai = 1" +
                    "INNER JOIN dungluongrom dr ON pbs.rom = dr.madlrom " +
                    "INNER JOIN dungluongram dlram ON pbs.ram = dlram.madlram";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ProductVersion productVersion = new ProductVersion();
                productVersion.setId(resultSet.getInt("id"));
                productVersion.setName(resultSet.getString("name"));
                productVersion.setPrice(resultSet.getDouble("price"));
                productVersion.setSizeScreen(resultSet.getInt("sizeScreen"));
                productVersion.setRam(resultSet.getInt("ram"));
                productVersion.setRom(resultSet.getInt("rom"));
                productVersion.setPhoto(resultSet.getString("photo"));
                productVersion.setQuantity(resultSet.getInt("quantity"));
                productVersionList.add(productVersion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return productVersionList;
    }

    public void updateQuantity(int id, int newQuantity) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectToSQLServer.getConnection();
            String query = "UPDATE phienbansanpham SET soluongton = ? WHERE maphienbansp = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, newQuantity);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

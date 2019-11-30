package com.example;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private final BasicDataSource dataSource;

    public Database(String databaseName) {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/" + databaseName + "?useUnicode=yes&characterEncoding=UTF-8");
        dataSource.setValidationQuery("SELECT 1");
    }

    public void printAll() {
        String query = "SELECT * FROM users";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String vardas = resultSet.getString("name");
                String pavarde = resultSet.getString("surname");
                int amzius = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Vardas: " + vardas
                        + ", Pavarde: " + pavarde + ", amzius: " + amzius);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String name, String surname, int age, double height) {
        String query = "INSERT INTO users (name, surname, age, height)"
                + " VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt(3, age);
            statement.setDouble(4, height);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateName(int id, String name) {
        String query = "UPDATE users SET name=? WHERE id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE FROM users WHERE id=?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName){
        String query = "CREATE TABLE " + tableName
                + " (id INTEGER NOT NULL AUTO_INCREMENT, "
                + "vardas VARCHAR(255), PRIMARY KEY(id))";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTable(String tableName){
        String query = "DROP TABLE " + tableName;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

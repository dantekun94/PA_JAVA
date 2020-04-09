package com.example.helloworld;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection con;
    private String url = "jdbc:mysql://localhost/MusicAlbums";
    private String username = "dba";
    private String password = "sql";

    private DatabaseConnection() throws SQLException {
        try {

            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    url, username, password);
        } catch (SQLException e) {
            System.out.println("Database Connection Creation Failed : " + e);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Main class");
    }
}
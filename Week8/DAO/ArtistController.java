package DAO;

import Domain.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistController extends BaseDAOController{
    public ArtistController(Connection conn) {
        super(conn);
    }

    public Artist findByName(String name){
        Artist artist = null;
        try {
            String sql = "select * from artists where name= ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("name");
                String country = rs.getString("country");
                artist = new Artist(id, nume, country);
            }
        }
        catch
        (Exception ex){
            System.out.println(ex.getMessage());
        }
        return artist;
    }

    public void create(String name, String country) {
        try {
            String sql = "INSERT INTO artists(name, country) values(?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            stat.setString(2, country);
            stat.executeUpdate();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

package DAO;

import Domain.Album;
import Domain.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumController extends BaseDAOController{
    public AlbumController(Connection conn) {
        super(conn);
    }

    public Album findByArtist(int artistId){
        Album album = null;
        try {
            String sql = "select * from albums where artist_id= ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1, artistId);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int releaseYear = rs.getInt("release_year");
                album = new Album(id,name,artistId,releaseYear);
            }
        }
        catch
        (Exception ex){
            System.out.println(ex.getMessage());
        }
        return album;
    }

    public void create(String name, int artistId, int releaseYear) {
        try {
            String sql = "INSERT INTO albums(name, artist_id, release_year) values(?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, name);
            stat.setInt(2, artistId);
            stat.setInt(3, releaseYear);
            stat.executeUpdate();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

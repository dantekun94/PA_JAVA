import DAO.AlbumController;
import DAO.ArtistController;
import Utils.DatabaseConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = null;
        try {
            databaseConnection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArtistController artistController = new ArtistController(databaseConnection.getConnection());
        System.out.println(artistController.findByName("Horia Brenciu"));
        artistController.create("Nedelcasd ASs", "Vicovu de Jos");
        System.out.println(artistController.findByName("Nedelcasd ASs"));

        AlbumController albumController = new AlbumController(databaseConnection.getConnection());
        try {
            System.out.println(albumController.findByArtist(1));
            albumController.create("Metallica", 1, 2019);
            System.out.println(albumController.findByArtist(1));
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}

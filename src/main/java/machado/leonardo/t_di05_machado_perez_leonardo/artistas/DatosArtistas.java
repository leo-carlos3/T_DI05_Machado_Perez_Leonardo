package machado.leonardo.t_di05_machado_perez_leonardo.artistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatosArtistas {

    private static DatosArtistas singleton = null;
    private ObservableList<Artista> listaArtistas = FXCollections.observableArrayList();

    private DatosArtistas() {}

    public static DatosArtistas  getInstancia() {
        if (singleton == null) {
            singleton = new DatosArtistas();
        }
        return singleton;
    }

    public ObservableList<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas() {
            // connection string
            var url = "jdbc:sqlite:chinook.db";
            try (var conn = DriverManager.getConnection(url)) {
                System.out.println("Connection to SQLite has been established.");
                ResultSet results=conn.prepareStatement("Select * from artists").executeQuery();
                listaArtistas = FXCollections.observableArrayList();
                while (results.next()) {
                    Artista artista=new Artista(results.getInt("ArtistId"), results.getString("Name"));
                    listaArtistas.add(artista);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }
}

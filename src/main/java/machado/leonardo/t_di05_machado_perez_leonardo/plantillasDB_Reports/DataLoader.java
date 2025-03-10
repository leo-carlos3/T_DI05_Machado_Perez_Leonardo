package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataLoader {

    private static ObservableList<Entity> lista = FXCollections.observableArrayList();

    private static DataLoader SINGLETON;
    private DataLoader(){}


    public static DataLoader getInstancia() {
        if (SINGLETON == null) {
            SINGLETON = new DataLoader();
        }
        return SINGLETON;
    }


    public static ObservableList<Entity> getLista() {
        return lista;
    }

    public static void setListaEntidad() {
        try (var conn = DbConnection.getConnection()) {
            if (conn != null) {
                ResultSet results = DbConnection.getConnection().prepareStatement("Select * from artists").executeQuery();
                lista = FXCollections.observableArrayList();
                while (results.next()) {
                    Entity e = new Entity(results.getInt("ArtistId"), results.getString("Name"));
                    System.out.println(e);
                    lista.add(e);
                }
            }
              else{
                  System.out.println("No se encontró la base de datos");
                }

    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


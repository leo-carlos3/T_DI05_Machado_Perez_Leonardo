package machado.leonardo.t_di05_machado_perez_leonardo.plantillasJson_ListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosJson {

    private static DatosJson instancia = null;
    private static ObservableList<Entidad> listaPeliculas = FXCollections.observableArrayList();

    private static void DatosFilmoteca () {
    }

    public static DatosJson getInstancia() {
        if (instancia == null) {
            instancia = new DatosJson();
        }
        return instancia;
    }

    public static ObservableList<Entidad> getListaPeliculas() {
        return listaPeliculas;
    }

    public static void setListaPeliculas(ObservableList<Entidad> listaPeliculas) {
        DatosJson.listaPeliculas = listaPeliculas;
    }
}
package machado.leonardo.t_di05_machado_perez_leonardo.plantillasJson_ListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonMain {
    public void init() {
        //System.out.println("Cargando datos desde fichero datos/peliculas.json");
        DatosJson datos = DatosJson.getInstancia();
        loadMovies();
        Platform.setImplicitExit(true);

    }

    public void stop() {
        ObservableList<Entidad> listaPeliculas = DatosJson.getInstancia().getListaPeliculas();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(new File("datos/peliculas.json"),listaPeliculas);
        }catch (IOException e) {
            System.out.println("ERROR no se ha podido guardar los datos de la aplicación");
            e.printStackTrace();
        }

    }
    public void loadMovies(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Entidad> lista = mapper.readValue(new File("datos/peliculas.json"),
                    mapper.getTypeFactory().constructCollectionType(List.class, Entidad.class));

            DatosJson.getListaPeliculas().setAll(lista);
        } catch (IOException e){
            System.err.println("ERROR al cargar los datos. La aplicación no puede iniciarse");
            e.printStackTrace();
            System.exit(1);
        }

    }

}

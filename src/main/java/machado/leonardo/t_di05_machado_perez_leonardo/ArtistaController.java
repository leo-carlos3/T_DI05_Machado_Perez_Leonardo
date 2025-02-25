package machado.leonardo.t_di05_machado_perez_leonardo;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import machado.leonardo.t_di05_machado_perez_leonardo.artistas.Artista;
import machado.leonardo.t_di05_machado_perez_leonardo.artistas.DatosArtistas;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ArtistaController {
    DatosArtistas datosArtistas = DatosArtistas.getInstancia();
    @FXML
    ListView<Artista> artistas;
    @FXML
    Text texto;

    @FXML
    protected void botonGenerar() {
        Artista seleccionado = artistas.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            texto.setText("Seleccione un artista");
            generarInformeArtista(seleccionado);
        } else {
            texto.setText("Por favor, seleccione un artista");
        }
    }

    @FXML
    protected void initialize() {
        datosArtistas.setListaArtistas();
        artistas.setItems(datosArtistas.getListaArtistas());
        System.out.println("Datos de artistas cargados");

    }
    //El informe de artistas mostrará una ventana un listview con todos los artistas.
    // Al seleccionar uno de ellos se generará el informe de artista.
    //El informe de artistas contendrá un encabezado con el nombre de la empresa y su logo.
    // Después  Aparecerá el nombre del artista seguido con un listado de los albums de dicho artista.
    // Para cada albúm también aparecerán las pistas (tracks) que tiene cada uno de los álbunes.

    private void generarInformeArtista(Artista artista) {
        String jasperFilePath = "informes/informeArtista.jrxml";
        InputStream inputStream = ReportApplication.class.getResourceAsStream(jasperFilePath);
        // Compilar el informe JRXML a un archivo Jasper
        System.out.println("Compilando : " + jasperFilePath);
        String url = "jdbc:sqlite:chinook.db";
        JasperReport jasperReport = null;
        try (var conn = DriverManager.getConnection(url)) {
            jasperReport = JasperCompileManager.compileReport(inputStream);
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("id", artista.getId()+"");
            System.out.println(params.values());
            // Al informe compilado le cargamos los parametros y la conexión a la base de datos
            System.out.println("Connection to SQLite has been established.");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

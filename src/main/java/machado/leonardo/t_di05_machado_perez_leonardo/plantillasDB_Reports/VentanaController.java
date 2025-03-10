package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

import java.util.HashMap;

public class VentanaController {
    public Button botonArtistas;
    DataLoader datos = DataLoader.getInstancia();
    @FXML
    ListView<Entity> lista;
    @FXML
    Text texto;

    @FXML
    protected void botonGenerar() {
        Entity seleccionado = lista.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            texto.setText("Seleccione un artista");
            generarInformeEntidad(seleccionado);
        } else {
            texto.setText("Por favor, seleccione un artista");
        }
    }

    @FXML
    protected void initialize() {
        DataLoader.setListaEntidad();
        lista.setItems(DataLoader.getLista());
        System.out.println("Datos de artistas cargados");

    }

@FXML
    private void generarInformeEntidad(Entity a) {
        String jasperFilePath = "informes/informeArtista.jrxml";

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", a.getId() + "");
    params.put("logo", ClassLoader.getSystemResourceAsStream("logo.jpg"));
        System.out.println(params.values());
        ReportManager.informe(jasperFilePath, params);
    }



}

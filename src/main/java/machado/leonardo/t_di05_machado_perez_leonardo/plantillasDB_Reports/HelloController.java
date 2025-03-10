package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void informeEntidad() {
        String jasperFilePath = "informes/informeClientes.jrxml";
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("logo", ClassLoader.getSystemResourceAsStream("logo.jpg"));
        ReportManager.informe(jasperFilePath, parametros);
    }
    @FXML
    public void informeVentana() {
        ReportManager.abrirVentana("Entidad");
    }

    @FXML
    protected void exit() {
        quitDialog();
    }
    public static void quitDialog(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Cerrar aplicación?");
        alert.setHeaderText("Si sales, luego podrás volver a iniciar la aplicación.");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> Platform.exit());
    }
}
package machado.leonardo.t_di05_machado_perez_leonardo;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportController {
    /*
    La aplicación al iniciarse debe conectarse a una base de datos SQLite suministrada en esta tarea.

Se debe usar documentos fxml para las vistas de la aplicación.
La aplicación debe usar una hoja de estilo y debe tener un aspecto diferente al por defecto de la aplicación.
No se pueden incrustar estilos a los componentes directamente si no es a través de la hoja de estilos.
     */

    @FXML
    protected void informeClientes()
    {
        //El informe de clientes contendrá un encabezado con el nombre de la empresa y su logo.
        //Después saldrá un listado con todos los clientes almacenados en la base de datos
        // y finalmente una fila de resumen con el número total de clientes mostrados.
        try {
            String jasperFilePath = "informes/informeClientes.jrxml";
            InputStream inputStream = ReportApplication.class.getResourceAsStream(jasperFilePath);


            // Compilar el informe JRXML a un archivo Jasper
            System.out.println("Compilando : " + jasperFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("logo", ClassLoader.getSystemResourceAsStream("logo.jpg"));

            String url = "jdbc:sqlite:chinook.db";
            // Al informe compilado le cargamos los parametros y la conexión a la base de datos
            try (var conn = DriverManager.getConnection(url)) {
                System.out.println("Connection to SQLite has been established.");
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (JRException e) {
            System.err.println(e.getMessage());
        }
    }
    @FXML
    protected void informeArtistas() {
        FXMLLoader fxmlLoader = new FXMLLoader(ReportController.class.getResource("artista-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Informe de artistas");
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
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
package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportManager {
    /**
     * Crea un informe con jasperReports y lo muestra
    @param reportPath-> ruta del archivo jrxml que se usará como plantilla
     @param params-> parámetros a aplicar por la plantilla
     */
    public static void informe(
            String reportPath, HashMap<String, Object> params){
        try (Connection conn = DbConnection.getConnection())
        {
            InputStream inputStream=ReportManager.class.getResourceAsStream(reportPath);
            System.out.println("Compilando : " + reportPath);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    public static void abrirVentana(String titulo){
        FXMLLoader fxmlLoader = new FXMLLoader(ReportManager.class.getResource("artista-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        }


}

package machado.leonardo.t_di05_machado_perez_leonardo.plantillasJson_ListView;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Dialogs {
    public static void quitDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Cerrar aplicación?");
        alert.setHeaderText("Si sales, luego podrás volver a iniciar la aplicación.");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> Platform.exit());
    }

    public static void removeDialog(int id) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("¿Eliminar película?");
        alert.setHeaderText("Si la eliminas, desaparecerá para siempre");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> unMetodo(id));
    }
    
    private static void unMetodo(int parametro){
        
    }

    public static void noMovieSelected() {
    }

    public static void editMovie(Entidad selectedItem) {
    }

    public static void addMovie() {
    }
}
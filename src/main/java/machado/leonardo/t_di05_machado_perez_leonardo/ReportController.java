package machado.leonardo.t_di05_machado_perez_leonardo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReportController {
    /*
    La aplicación al iniciarse debe conectarse a una base de datos SQLite suministrada en esta tarea.



Se debe usar documentos fxml para las vistas de la aplicación.
La aplicación debe usar una hoja de estilo y debe tener un aspecto diferente al por defecto de la aplicación.
No se pueden incrustar estilos a los componentes directamente si no es a través de la hoja de estilos.
     */
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void informeClientes()
    {
        //El informe de clientes contendrá un encabezado con el nombre de la empresa y su logo.
        //Después saldrá un listado con todos los clientes almacenados en la base de datos
        // y finalmente una fila de resumen con el número total de clientes mostrados.
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void informeArtistas() {
        //El informe de artistas mostrará una ventana un listview con todos los artistas.
        // Al seleccionar uno de ellos se generará el informe de artista.
        //El informe de artistas contendrá un encabezado con el nombre de la empresa y su logo.
        // Después  Aparecerá el nombre del artista seguido con un listado de los albums de dicho artista.
        // Para cada albúm también aparecerán las pistas (tracks) que tiene cada uno de los álbunes.
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void exit() {


        welcomeText.setText("Welcome to JavaFX Application!");
    }

}
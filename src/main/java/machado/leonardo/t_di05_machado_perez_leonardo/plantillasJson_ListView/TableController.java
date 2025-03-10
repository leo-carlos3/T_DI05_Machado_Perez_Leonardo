package machado.leonardo.t_di05_machado_perez_leonardo.plantillasJson_ListView;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class TableController {
    @FXML
    private HBox infoBox;
    @FXML
    private Text info;
    @FXML
    private TableView<Entidad> table;
    @FXML
    private TableColumn<Entidad, String> title;
    @FXML
    private TableColumn<Entidad, String> year;
    @FXML
    private TableColumn<Entidad, String> id;
    @FXML
    private TableColumn<Entidad, String> rating;
    @FXML
    private TextField searchBar;

    @FXML
    public void searchConfig(){

        searchBar.setPromptText("Título de la película");
        FilteredList<Entidad> filteredData = new FilteredList<>(DatosJson.getListaPeliculas(), p -> true);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(movie -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                return movie.getTitle().toLowerCase().contains(newValue.toLowerCase());
            });
        });
        table.setItems(filteredData);

    }

    @FXML
    public void clearSearch(MouseEvent mouseEvent) {
        searchBar.clear();
    }

    @FXML
    public void initialize() {
        table.setItems(DatosJson.getListaPeliculas());
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        rating.setCellValueFactory(new PropertyValueFactory<>("rating"));
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        onRowSelected(newValue);
                    }
                }
        );
        //configura la búsqueda
        searchConfig();



    }
    @FXML
    public void onRowSelected(Entidad pelicula) {
        if (infoBox.getChildren().getFirst()!=infoBox.getChildren().getLast())
        {
            infoBox.getChildren().removeLast();
        }
        String movieInfo=(
                "Título: "+
                        pelicula.getTitle()+
                        ". Año de estreno: "+ pelicula.getYear()+
                        ". Descripción: "+pelicula.getDescription()+
                        "  Valoración media: "+pelicula.getRating()+
                        ".  ID: "+pelicula.getId()
        );
        info.setText(movieInfo);
        ImageView poster=new ImageView(pelicula.getPoster());
        poster.setPreserveRatio(true);
        poster.setFitHeight(200);
        infoBox.getChildren().add(poster);

    }
    @FXML
    public void quitDialog() {
        Dialogs.quitDialog();
    }
    @FXML
    public void removeDialog() {
        if (table.getSelectionModel().getSelectedItem() != null)
        {
            Dialogs.removeDialog(table.getSelectionModel().getSelectedItem().getId());
        }
        else{
            Dialogs.noMovieSelected();
        }
    }
    @FXML
    public void addMovie(){
        Dialogs.addMovie();
    }
    @FXML
    public void editMovie(){
        if (table.getSelectionModel().getSelectedItem() != null)
        {
            Dialogs.editMovie(table.getSelectionModel().getSelectedItem());
        }
        else {
            Dialogs.noMovieSelected();
        }
    }
}

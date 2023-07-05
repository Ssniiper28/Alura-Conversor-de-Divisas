package mx.com.alura.conversoralura;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class AppController {
    @FXML
    private VBox container;

    public static VBox menu;
    @FXML
    private Button minBtn;
    @FXML
    private Button closeBtn;

    Double xOffset, yOffset;
    @FXML
    private HBox menuBar;

    @FXML
    public void initialize() throws IOException {
        // Cargar el menu dentro de la interfaz
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("/views/menu.fxml"));
        menu = fxmlLoader.load();
        container.getChildren().add(menu);
    }

    public static void setVista(String fxml)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("/views/"+fxml));
        menu.getChildren().clear();
        menu.getChildren().add(fxmlLoader.load());
    }

    public static void menu() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("/views/menu.fxml"));
        menu.getChildren().clear();
        menu.getChildren().add(fxmlLoader.load());
    }

    @FXML
    public void minimize(ActionEvent actionEvent) {
        Stage stage = (Stage) minBtn.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void setCoordinates(MouseEvent event){
        xOffset = menuBar.getScene().getWindow().getX() - event.getScreenX();
        yOffset = menuBar.getScene().getWindow().getY() - event.getScreenY();
        System.out.println(xOffset + "  " + yOffset);

    }

    @FXML
    public void moveWindow(MouseEvent event) {
        menuBar.getScene().getWindow().setX(event.getScreenX() + xOffset);
        menuBar.getScene().getWindow().setY(event.getScreenY() + yOffset);
    }
}
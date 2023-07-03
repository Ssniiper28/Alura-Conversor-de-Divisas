package mx.com.alura.conversoralura;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AppController {
    @FXML
    private VBox container;

    public static VBox menu;

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
}
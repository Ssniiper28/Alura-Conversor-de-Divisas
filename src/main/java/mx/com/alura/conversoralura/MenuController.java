package mx.com.alura.conversoralura;

import helpers.Vista;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;


public class MenuController {
    @FXML
    public void initialize() {
    }

    @FXML
    public void initConvertidor() throws IOException {
        AppController.setVista("convertidor.fxml");
    }

    @FXML
    public void initMedidas() throws IOException{
        AppController.setVista("convertidorMedidas.fxml");
    }
}
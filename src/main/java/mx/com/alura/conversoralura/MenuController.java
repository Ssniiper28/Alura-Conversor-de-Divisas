package mx.com.alura.conversoralura;

import helpers.Vista;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;


public class MenuController {
    @FXML
    private VBox container;

    @FXML
    public void initialize() {

    }

    @FXML
    public void initConvertidor() throws IOException {
        ConvertidorController.conversionType = "moneda";
        AppController.setVista("convertidor.fxml");
    }

    @FXML
    public void initMedidas() throws IOException{
        ConvertidorController.conversionType = "longitud";
        AppController.setVista("convertidor.fxml");
    }

    @FXML
    public void initConvArea() throws IOException{
        ConvertidorController.conversionType = "area";
        AppController.setVista("convertidor.fxml");
    }

    @FXML
    public void initConvMasa() throws IOException {
        ConvertidorController.conversionType = "masa";
        AppController.setVista("convertidor.fxml");
    }
}
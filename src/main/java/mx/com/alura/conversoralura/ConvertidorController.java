package mx.com.alura.conversoralura;

import helpers.FixedDecimalConverter;
import helpers.FixedDecimalFilter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import models.Convertidor;
import models.Currency;
import javafx.event.Event;
import models.Unit;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConvertidorController implements Initializable {
    private ObjectProperty<Double> valueProperty = new SimpleObjectProperty<>(0d);
    private Convertidor convertidor = new Convertidor();
    @FXML
    private TextField entrada;
    @FXML
    private ComboBox<Unit> fromCurrency;
    @FXML
    private TextField salida;
    @FXML
    private ComboBox<Unit> toCurrency;

    public static String conversionType = "";
    @FXML
    private Label title;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Limitar el TextField a que solo acepte numeros double con 2 decimales maximo
        TextFormatter<Double> textFormatter = new TextFormatter(new FixedDecimalConverter(2), 78, new FixedDecimalFilter());
        textFormatter.valueProperty().bind(valueProperty);
        entrada.setTextFormatter(textFormatter);
        salida.setTextFormatter(new TextFormatter(new FixedDecimalConverter(2)));
        salida.setText("0.00");
        // Inicializar ComboBox con la lista del convertidor
        setConversionModel();
        // Seleccionar opciones por defecto
        fromCurrency.getSelectionModel().select(0);
        toCurrency.getSelectionModel().select(1);
    }

    @FXML
    public void convertir(Event event) {
        try {
            double exchange = convertidor.convertir(Double.parseDouble(entrada.getText()), fromCurrency.getValue(), toCurrency.getValue());
            salida.setText(exchange + "");
        } catch (NumberFormatException e){
            System.out.println("NumberFormat Exception");
        }

    }

    @Deprecated
    public void regresar(Event event) throws IOException {
        AppController.menu();
    }

    @FXML
    public void reset(Event event) {
        entrada.selectAll();
    }

    private void setConversionModel(){
        switch (conversionType){
            case "moneda":
                title.setText("Conversor de Monedas");
                fromCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getCurrencies()
                ));
                toCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getCurrencies()
                ));
                break;
            case "longitud":
                title.setText("Conversor de Medidas");
                fromCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getLengths()
                ));
                toCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getLengths()
                ));
                break;
            case "area":
                title.setText("Conversor de Areas");
                fromCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getAreas()
                ));
                toCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getAreas()
                ));
                break;
            case "masa":
                title.setText("Conversor de Masas");
                fromCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getMasses()
                ));
                toCurrency.setItems(FXCollections.observableArrayList(
                        convertidor.getMasses()
                ));
                break;
        }
    }
}
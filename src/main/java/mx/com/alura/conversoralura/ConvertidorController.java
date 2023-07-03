package mx.com.alura.conversoralura;

import helpers.FixedDecimalConverter;
import helpers.FixedDecimalFilter;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import models.Convertidor;
import models.Currency;
import javafx.event.Event;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConvertidorController implements Initializable {
    private ObjectProperty<Double> valueProperty = new SimpleObjectProperty<>(0d);
    private Convertidor convertidor = new Convertidor();
    @FXML
    private TextField entrada;
    @FXML
    private ComboBox<Currency> fromCurrency;
    @FXML
    private TextField salida;
    @FXML
    private ComboBox<Currency> toCurrency;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Limitar el TextField a que solo acepte numeros double con 2 decimales maximo
        TextFormatter<Double> textFormatter = new TextFormatter(new FixedDecimalConverter(2), 78, new FixedDecimalFilter());
        textFormatter.valueProperty().bindBidirectional(valueProperty);
        entrada.setTextFormatter(textFormatter);
        salida.setTextFormatter(new TextFormatter(new FixedDecimalConverter(2)));
        salida.setText("0.00");
        // Inicializar ComboBox con la lista del convertidor
        fromCurrency.setItems(FXCollections.observableArrayList(
                convertidor.getCurrencies()
        ));

        toCurrency.setItems(FXCollections.observableArrayList(
                convertidor.getCurrencies()
        ));

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

    @FXML
    public void regresar(Event event) throws IOException {
        AppController.menu();
    }
}
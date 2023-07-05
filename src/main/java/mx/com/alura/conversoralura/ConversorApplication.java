package mx.com.alura.conversoralura;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ConversorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("/views/containerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Conversor Alura");
        stage.getIcons().add(new Image(ConversorApplication.class.getResourceAsStream("/assets/exchange.png")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
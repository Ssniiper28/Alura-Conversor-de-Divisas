module mx.com.alura.conversoralura {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens mx.com.alura.conversoralura to javafx.fxml;
    exports mx.com.alura.conversoralura;
}
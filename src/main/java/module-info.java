module ma.enset.gestioncabinet {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;
    requires mysql.connector.j;
    requires java.sql;
    requires java.security.sasl;

    opens ma.enset.gestioncabinet.controllers to javafx.fxml;
    opens ma.enset.gestioncabinet.entities to javafx.base;

    exports ma.enset.gestioncabinet;
}

module com.conversor.conversor{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens com.conversor.conversor.Util to javafx.fxml, com.google.gson;
    exports com.conversor.conversor.Util;

    opens com.conversor.conversor.Controller to javafx.fxml, javafx.graphics;
    exports com.conversor.conversor.Controller;

    opens com.conversor.conversor to javafx.graphics;
    exports com.conversor.conversor;
    exports com.conversor.conversor.DTO;
    opens com.conversor.conversor.DTO to com.google.gson, javafx.fxml;


}
package com.conversor.conversor.Controller;

import com.conversor.conversor.ConversorApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnMedidas;

    @FXML
    private Button btnTemperatura;

    @FXML
    private Label txtTitle;

    @FXML
    void getMonedasView(ActionEvent event) throws IOException {
        ConversorApplication.setStage("conversorDivisas");
    }

    @FXML
    void getTemperaturaView(ActionEvent event) throws IOException {
        ConversorApplication.setStage("conversorTemperatura");

    }

}
